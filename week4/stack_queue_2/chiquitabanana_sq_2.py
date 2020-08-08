import math

def solution(progresses, speeds):
    answer = [0]
    days = [math.ceil((100 - p) / s) for p, s in zip(progresses, speeds)]
    bf = days[0]
    
    for day in days:
        if day <= bf:
            answer[-1] += 1
            bf = max(bf, day)
        else:
            answer.append(1)
            bf = day
    
    return answer