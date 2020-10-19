import bisect
import math

def solution(n, times):
    answer = 0
    left = 0
    right = math.ceil(max(times) * n / len(times))
    # li = [sum([tot_time//time for time in times]) for tot_time in range(0, max_time+1)]
    # answer = bisect.bisect_left(li, n)
    while left <= right:
        cur = (left + right) // 2
        # 처리할 수 있는 인원
        proc_num = sum([cur//time for time in times])
        if proc_num >= n:
            # 최소 cur을 끝까지 찾는다
            answer = cur
            right = cur - 1
        elif proc_num < n:
            left = cur + 1
    return answer


if __name__ == '__main__':
    n = 6
    times = [7, 10]
    assert solution(n, times) == 28