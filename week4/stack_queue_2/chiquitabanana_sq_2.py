import math

def solution(progresses, speeds):
    answer = [0]
    
    # 작업 별 완료까지 남은 일수
    days = [math.ceil((100 - p) / s) for p, s in zip(progresses, speeds)]
    
    # 이전 작업을 위해 필요한 일수 
    bf = days[0]
    
    for day in days:
        if day <= bf:
            answer[-1] += 1

            # 같이 배포되는 작업 중 가장 오래 걸리는 것 기준
            bf = max(bf, day)
        else:
            answer.append(1)
            bf = day
    
    return answer