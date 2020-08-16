import heapq
from collections import deque


def solution(jobs):
    # 정렬 필수
    len_jobs = len(jobs)
    jobs = deque(sorted(jobs, key=lambda x: x[0]))

    # [종료시간 - 요청시간]
    proc_times = []

    # heapq
    requests = []

    processor = deque()
    time = 0
    while len(proc_times) < len_jobs:
        while len(jobs) != 0:
            job = jobs.popleft()
            if job[0] <= time:
                heapq.heappush(requests, (job[1], job))
            else:
                jobs.appendleft(job)
                break

        if len(processor) == 0 and len(requests) != 0:
            req = heapq.heappop(requests)
            processor.append(req[1])

        if len(processor) != 0:
            proc = processor.popleft()
            time += proc[1]
            proc_times.append(time - proc[0])
        else:
            time += 1

    answer = int(sum(proc_times) / len(proc_times))
    return answer


j1 = [[0, 3], [1, 9], [2, 6]]
j2 = [[0, 3], [2, 6], [1, 9]]
j3 = [[0, 3], [5, 5]]

print(solution(j1))
print(solution(j2))
print(solution(j3))
