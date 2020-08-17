from queue import Queue

def solution(bridge_length, weight, truck_weights):
    que = Queue(maxsize=bridge_length)
    i, w, s = 0, 0, 0
    
    while not que.empty() or i < len(truck_weights):
        if not que.empty() and s - que.queue[0][1] == bridge_length:
            w -= que.get()[0]
        if not que.full() and i < len(truck_weights) and w + truck_weights[i] <= weight:
            que.put((truck_weights[i], s))
            w += truck_weights[i]
            i += 1
        s += 1
    
    return s