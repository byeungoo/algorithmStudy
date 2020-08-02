from itertools import combinations


def solution(brown, yellow):
    answer = []

    yellows = getCombinations(getDivisors(yellow), yellow)
    for y in yellows:
        if (y[0] + 2) * (y[1] + 2) == brown + yellow:
            answer = [y[0] + 2, y[1] + 2]

    return answer


def getDivisors(num):
    divisors = []
    for i in range(1, num + 1):
        if num % i == 0:
            divisors.append(i)

    return divisors


def getCombinations(divisors, num):
    if num == 1:
        return [[1, 1]]

    combs = []
    for c in list(combinations(divisors, 2)):
        if c[0] * c[1] == num:
            combs.append(sorted(list(c), reverse=True))
        if c[0] * c[0] == num:
            combs.append([c[0], c[0]])

    return combs


b1, y1 = 10, 2
b2, y2 = 8, 1
b3, y3 = 24, 24
b4, y4 = 12, 4

print(solution(b1, y1))
print(solution(b2, y2))
print(solution(b3, y3))
print(solution(b4, y4))
