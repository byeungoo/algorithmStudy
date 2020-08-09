from collections import deque


def solution(prices):
    answer = []

    stk = []

    for i in range(len(prices)):
        num = prices[i]
        stk.append(num)
        que = deque(prices[i + 1:])

        # print(stk, que)

        for j in range(len(que)):
            if que.popleft() < num:
                stk.pop()
                answer.append(j + 1)
                break
        if len(stk) != 0:
            stk.pop()
            answer.append(len(prices) - 1 - i)

    return answer


p1 = [1, 2, 3, 2, 3]
p2 = [5, 4, 3, 3, 2]
p3 = [1, 2, 3, 4, 5]
p4 = [3, 3, 3, 2, 3]

print(solution(p1))
print(solution(p2))
print(solution(p3))
print(solution(p4))
