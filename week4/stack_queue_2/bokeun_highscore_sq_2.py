from collections import deque


def solution(progresses, speeds):
    answer = []
    pQueue, sQueue = deque(progresses), deque(speeds)

    while len(pQueue) != 0:

        for i in range(len(pQueue)):
            speed = sQueue.popleft()
            pQueue.append(pQueue.popleft() + speed)
            sQueue.append(speed)

        count = 0
        while len(pQueue) != 0:
            first = pQueue.popleft()
            if first >= 100:
                count += 1
            else:
                pQueue.appendleft(first)
                break

        if count > 0:
            answer.append(count)
            for i in range(count):
                sQueue.popleft()

    return answer


p1 = [93, 30, 55]
s1 = [1, 30, 5]

print(solution(p1, s1))
