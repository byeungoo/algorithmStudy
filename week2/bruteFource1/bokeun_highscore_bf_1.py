def solution(answers):
    answer = []
    max = 0
    pattern = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]

    for i in range(3):
        score = 0
        idx = 0
        for j in range(len(answers)):
            if answers[j] == pattern[i][idx]:
                score += 1
            idx += 1
            if idx == len(pattern[i]):
                idx = 0
        if len(answer) == 0 or score == max:
            max = score
            answer.append(i + 1)
        elif score > max:
            max = score
            answer.pop()
            answer.append(i + 1)

    return answer


tc1 = [1, 2, 3, 4, 5]
tc2 = [1, 3, 2, 4, 2]

print(solution(tc1))
print(solution(tc2))
