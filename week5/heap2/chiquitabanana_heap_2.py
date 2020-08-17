import heapq, math

def solution(jobs):
    h = []
    tot_time = 0
    cur_time = 0
    cur_job = 0
    jobs.sort(key=lambda x: x[0])
    
    while True:
        for job in jobs[cur_job:]:
            if job[0] <= cur_time:
                heapq.heappush(h, (job[1], job[0]))
                cur_job += 1
        if h:
            spd_time, req_time = heapq.heappop(h)
            tot_time += cur_time - req_time + spd_time
            cur_time += max(spd_time, 1)
        else:
            cur_time += 1
            
        if cur_job == len(jobs) and not h:
            break
            
    return math.floor(tot_time/len(jobs))