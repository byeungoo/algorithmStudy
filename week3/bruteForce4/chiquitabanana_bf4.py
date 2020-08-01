def solution(brown, yellow):
    for i in range(1,2500):
        for j in range(1,2500):
            if i*j == brown + yellow and (i-2)*(j-2) == yellow:
                return sorted([i, j], reverse=True)