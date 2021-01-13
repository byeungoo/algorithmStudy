def count_rocks(dist_rocks, mid):
    del_rocks = 0
    sum_dist = 0
    min_dist = 1000000001
    for dist in dist_rocks:
        sum_dist += dist
        if sum_dist < mid:
            # 더 작은 경우 돌을 없애고 카운트 증가
            del_rocks += 1
        else:
            # 더 큰 경우 최소거리 기록, 그 다음부터 거리 측정
            min_dist = min(dist, min_dist)
            sum_dist = 0
    return del_rocks

def solution(distance, rocks, n):
    answer = 0
    rocks.sort()
    rocks.append(distance)
    rocks = [0] + rocks
    dist_rocks = [rocks[i]-rocks[i-1] for i in range(1,len(rocks))]

    left = 1
    right = distance
    while left <= right:
        mid = (left + right) // 2
        del_rocks = count_rocks(dist_rocks, mid)
        if del_rocks > n:
            right = mid-1
        else:
            answer = mid
            left = mid+1

    return answer


if __name__ == '__main__':
    distance = 25
    rocks = [2,14,11,21,17]
    n = 2
    assert solution(distance,rocks,n) == 4