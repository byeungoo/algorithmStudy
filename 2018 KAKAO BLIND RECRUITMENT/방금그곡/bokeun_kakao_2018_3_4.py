from datetime import datetime


def solution(m, musicinfos):
    melody = convert_chords(m)

    musics = []
    for i, musicinfo_str in enumerate(musicinfos):
        music_info = musicinfo_str.split(",")
        play_time = get_play_time(music_info[0], music_info[1])
        sheet = convert_chords(music_info[3])
        played_chords = (sheet * (play_time // len(sheet) + 1))[:play_time]
        if " ".join(melody) + " " in " ".join(played_chords) + " ":
            musics.append((music_info[2], play_time, i))

    if len(musics) == 0:
        return "(None)"

    return sorted(musics, key=lambda x: (-x[1], x[2]))[0][0]


def get_play_time(start_time, end_time):
    return (datetime.strptime(end_time, "%H:%M") - datetime.strptime(start_time, "%H:%M")).seconds // 60


def convert_chords(chords: str):
    converted = []

    stack = []
    for chord in chords:
        if chord == "#" or len(stack) == 0:
            stack.append(chord)
        else:
            converted.append("".join(stack))
            stack = [chord]
    if len(stack) > 0:
        converted.append("".join(stack))

    return converted


m1 = "ABCDEFG"
mi1 = ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]
m2 = "CC#BCC#BCC#BCC#B"
mi2 = ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]
m3 = "ABC"
mi3 = ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]
m4 = "A"
mi4 = []
m5 = "C#D"
mi5 = ["12:00,12:02,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"]

print(solution(m1, mi1))
print(solution(m2, mi2))
print(solution(m3, mi3))
print(solution(m4, mi4))
print(solution(m5, mi5))
