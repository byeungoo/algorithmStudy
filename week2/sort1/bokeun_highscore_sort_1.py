def solution(array, commands):
    answer = []

    for c in commands:
        croped = sorted(array[c[0] - 1:c[1]])
        answer.append(croped[c[2] - 1])

    return answer


a1 = [1, 5, 2, 6, 3, 7, 4]
c1 = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]

print(solution(a1, c1))
