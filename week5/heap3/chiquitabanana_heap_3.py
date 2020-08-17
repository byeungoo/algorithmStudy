import heapq

def solution(operations):
    h = []
    for op in operations:
        a, n = tuple(op.split())
        if a == 'I':
            heapq.heappush(h, int(n))
        elif n == '1':
            h = h[:-1]
        elif n == '-1' and h:
            heapq.heappop(h)
    if h:
        return [max(h), h[0]]
    else:
        return [0,0]