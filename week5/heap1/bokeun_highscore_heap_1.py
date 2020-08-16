import heapq


def solution(scoville, K):
    answer = 0

    pq = scoville
    heapq.heapify(pq)

    while len(pq) > 1:
        answer += 1
        mix = heapq.heappop(pq) + heapq.heappop(pq) * 2
        heapq.heappush(pq, mix)

        least = heapq.heappop(pq)
        if least > K:
            break
        else:
            heapq.heappush(pq, least)

    if len(pq) == 1 and heapq.heappop(pq) < K:
        answer = -1

    return answer


s1 = [1, 2, 3, 9, 10, 12]
k1 = 7
print(solution(s1, k1))
