def solution(files):
    split = []
    for file in files:
        head, number, tail = "", "", ""
        head_end = 0
        for i in range(len(file) - 1):
            if head == "" and not file[i].isdigit() and file[i + 1].isdigit():
                head = file[:i + 1]
                head_end = i
            if number == "" and file[i].isdigit() and not file[i + 1].isdigit():
                number = file[head_end + 1:i + 1]
                tail = file[i + 1:]
                break
            if i == len(file) - 2:
                number = file[head_end + 1:]
        split.append([head, number, tail])
    split = sorted(split, key=lambda x: (x[0].lower(), int(x[1])))

    return ["".join(s) for s in split]


f1 = ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
f2 = ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
f3 = ["foo9.txt", "foo010bar020.zip", "F-15", "F2"]

print(solution(f1))
print(solution(f2))
print(solution(f3))
