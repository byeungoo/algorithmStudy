def solution(n, computers):
    disconnected = {i for i in range(1, n)}
    cnt = 1
    current = 0
    next = []
    while True:
        if not len(disconnected):
            break
        for i in range(n):
            if computers[current][i] and i in disconnected:
                next.append(i)
        if not len(next):
            cnt += 1
            current = list(disconnected)[0]
        else:
            current = next.pop()
            disconnected.discard(current)
        
    return cnt