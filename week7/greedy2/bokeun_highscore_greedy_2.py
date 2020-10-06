def solution(number, k):
    num = number

    for i in range(k):
        max = num[1:]
        for j in range(len(num)):
            tmp = num[:j] + num[j + 1:]
            if tmp >= max:
                max = tmp
        num = max

    return num


n1 = "1924"
k1 = 2
n2 = "1231234"
k2 = 3
n3 = "4177252841"
k3 = 4

print(solution(n1, k1))
print(solution(n2, k2))
print(solution(n3, k3))
