# 배경음악과 게임오버 소리를 합성해 bubble/sound에 저장한다
# 사용: python tools/make-sounds.py
import math
import struct
import wave

RATE = 22050
NOTES = {"C4": 261.63, "D4": 293.66, "E4": 329.63, "F4": 349.23, "G4": 392.00, "A4": 440.00,
         "B4": 493.88, "C5": 523.25, "D5": 587.33, "E5": 659.25, "G5": 783.99, "R": 0}


def tone(freq, seconds, volume):
    samples = []
    count = int(RATE * seconds)
    for i in range(count):
        fade = min(1.0, (count - i) / (RATE * 0.02))
        if freq == 0:
            value = 0
        else:
            value = volume * fade if math.sin(2 * math.pi * freq * i / RATE) >= 0 else -volume * fade
        samples.append(int(value))
    return samples


def save(path, samples):
    with wave.open(path, "wb") as f:
        f.setnchannels(1)
        f.setsampwidth(2)
        f.setframerate(RATE)
        f.writeframes(b"".join(struct.pack("<h", s) for s in samples))


beat = 0.18
melody = ["C5", "E5", "G5", "E5", "D5", "C5", "D5", "R", "E5", "G5", "E5", "D5", "C5", "D5", "C5", "R",
          "A4", "C5", "E5", "C5", "B4", "A4", "B4", "R", "C5", "D5", "E5", "D5", "C5", "B4", "C5", "R"]
bass = ["C4", "C4", "G4", "G4", "F4", "F4", "G4", "G4"]
bgm = []
for i, note in enumerate(melody):
    lead = tone(NOTES[note], beat, 2600)
    low = tone(NOTES[bass[(i // 4) % len(bass)]] / 2, beat, 1600)
    bgm += [a + b for a, b in zip(lead, low)]
save("bubble/sound/bgm.wav", bgm)

over = []
for note in ["G4", "F4", "E4", "D4", "C4"]:
    over += tone(NOTES[note], 0.22, 3000)
over += tone(NOTES["C4"] / 2, 0.6, 3000)
save("bubble/sound/gameover.wav", over)
print("bgm.wav, gameover.wav 저장")
