# tools/raw의 원본 그림을 게임에 쓰는 크기로 다듬어 bubble/image에 저장한다.
# 자홍(#FF00FF) 바탕은 투명하게 바꾸고, 그림 둘레를 잘라 정해진 칸에 맞춘다.
# 사용: python tools/make-images.py

from pathlib import Path

from PIL import Image

ROOT = Path(__file__).resolve().parent.parent
RAW = ROOT / "tools" / "raw"
OUT = ROOT / "bubble" / "image"


def is_magenta(r, g, b):
    return abs(r - 255) + g + abs(b - 255) < 90


def is_fringe(r, g, b):
    return abs(r - b) < 30 and min(r, b) - g > 50


def remove_magenta(image):
    image = image.convert("RGBA")
    pixels = image.load()
    width, height = image.size
    keyed = set()
    for y in range(height):
        for x in range(width):
            r, g, b, a = pixels[x, y]
            if is_magenta(r, g, b):
                keyed.add((x, y))
    for x, y in keyed:
        pixels[x, y] = (0, 0, 0, 0)
    for _ in range(3):
        edge = []
        for x, y in keyed:
            for nx, ny in ((x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)):
                if 0 <= nx < width and 0 <= ny < height and (nx, ny) not in keyed:
                    r, g, b, a = pixels[nx, ny]
                    if is_fringe(r, g, b):
                        edge.append((nx, ny))
        for x, y in edge:
            r, g, b, a = pixels[x, y]
            pink = min(r, b) - g
            pixels[x, y] = (g, g, g, max(0, 255 - pink))
            keyed.add((x, y))
    return image


def fit(image, width, height):
    box = image.getbbox()
    image = image.crop(box)
    scale = min(width / image.width, height / image.height)
    size = (max(1, round(image.width * scale)), max(1, round(image.height * scale)))
    image = image.resize(size, Image.LANCZOS)
    canvas = Image.new("RGBA", (width, height), (0, 0, 0, 0))
    canvas.paste(image, ((width - size[0]) // 2, height - size[1]), image)
    return canvas


def sprite(name):
    return fit(remove_magenta(Image.open(RAW / f"{name}.png")), 50, 50)


def save(image, name):
    image.save(OUT / name)
    print(name, image.size)


def main():
    OUT.mkdir(parents=True, exist_ok=True)

    player = sprite("player")
    save(player, "playerR.png")
    save(player.transpose(Image.FLIP_LEFT_RIGHT), "playerL.png")
    save(sprite("player-die"), "playerDie.png")

    enemy = sprite("enemy")
    save(enemy, "enemyR.png")
    save(enemy.transpose(Image.FLIP_LEFT_RIGHT), "enemyL.png")
    save(sprite("enemy-bubbled"), "enemyBubbled.png")

    save(sprite("bubble"), "bubble.png")

    brick = Image.open(RAW / "brick.png").convert("RGB")
    save(brick.crop((0, 0, 320, 160)).resize((40, 20), Image.LANCZOS), "brick.png")

    background = Image.open(RAW / "background.png").convert("RGB")
    left = (background.width - background.height * 1000 // 640) // 2
    background = background.crop((left, 0, left + background.height * 1000 // 640, background.height))
    save(background.resize((1000, 640), Image.LANCZOS), "background.png")

    for name, file in [("gameover", "gameover.png"), ("clear", "clear.png")]:
        text = remove_magenta(Image.open(RAW / f"{name}.png"))
        text = text.crop(text.getbbox())
        height = round(text.height * 500 / text.width)
        save(text.resize((500, height), Image.LANCZOS), file)


main()
