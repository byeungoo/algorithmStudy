from collections import deque

def solution(priorities, location):
    dq = deque([(i, p) for i, p in enumerate(priorities)])
    priorities.sort(reverse=True)
    count = 0
    
    while True:
        tup = dq.popleft()
        if tup[1] < priorities[0]:
            dq.append(tup)
        else:
            count += 1
            priorities = priorities[1:]
            if tup[0] == location:
                break
        
    return count