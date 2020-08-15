import heapq


def solution(scoville, K):
    heapq.heapify(scoville)
    count = 0

    while len(scoville) > 1:
        if scoville[0] >= K:
            return count

        heapq.heappush(scoville, heapq.heappop(
            scoville) + (heapq.heappop(scoville)*2))
        count += 1

    if scoville[0] >= K:
        return count

    return -1


print(solution([1, 2, 3, 9, 10, 12], 7))
