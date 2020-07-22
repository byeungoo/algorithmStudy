def solution(citations):
    n = len(citations)
    l = [min(n-i, val) for i, val in enumerate(sorted(citations))] 
    return max(l)