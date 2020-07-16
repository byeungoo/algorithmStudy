from collections import defaultdict

def solution(clothes):
    answer = 1
    d = defaultdict(int)
    
    for c in clothes:
        d[c[1]] += 1
    
    for key, i in d.items():
        answer *= i+1
    
    return answer - 1
