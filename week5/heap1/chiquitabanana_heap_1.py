import heapq

def solution(scoville, K):
    count = 0
    heapq.heapify(scoville)
    while True:
        a = heapq.heappop(scoville)
        if a >= K:
            break
        elif not scoville:
            count = -1
            break
        else:
            b = heapq.heappop(scoville)
            heapq.heappush(scoville, a + (b * 2))
            count += 1
    return count