import heapq


def solution(operations):
    pq = []
    for op in operations:
        cmd = op.split()

        if cmd[0] == "I":
            heapq.heappush(pq, int(cmd[1]))
        elif cmd[0] == "D" and len(pq) != 0:
            if cmd[1] == "1":
                pq.pop()
            elif cmd[1] == "-1":
                heapq.heappop(pq)

        pq = sorted(pq)

    if len(pq) == 0:
        answer = [0, 0]
    else:
        answer = [pq[-1], pq[0]]

    return answer


o1 = ["I 16", "D 1"]
o2 = ["I 7", "I 5", "I -5", "D -1"]
o3 = ["I 7", "I 6", "D 1"]
o4 = ["D -1"]
o5 = ["D -1", "I 5", "I 6", "I 5", "D 1", "I -1"]

print(solution(o1))
print(solution(o2))
print(solution(o3))
print(solution(o4))
print(solution(o5))
