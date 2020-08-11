from collections import deque


def solution(priorities, location):
    answer = 0

    stk = sorted(priorities)

    que = deque([(i, p) for i, p in enumerate(priorities)])
    while True:
        pop = que.popleft()
        if pop[1] == stk[-1]:
            answer += 1
            stk.pop()
            if pop[0] == location:
                break
        else:
            que.append(pop)

    return answer


p1 = [2, 1, 3, 2]
l1 = 2
p2 = [1, 1, 9, 1, 1, 1]
l2 = 0

print(solution(p1, l1))
print(solution(p2, l2))
