from collections import deque

def solution(m, n, puddles):
    list_map = [[0 for i in range(m)] for j in range(n)]
    for puddle in puddles:
        # 잠긴 지역 체크
        j, i = puddle[0], puddle[1]
        if i-1 in range(n) and j-1 in range(m):
            list_map[i-1][j-1] = -1
    
    li = deque([(0, 0)])
    list_map[0][0] = 1
    while li:
        print(li)
        cur = li.popleft()
        i, j = cur[0], cur[1]
        if list_map[i][j] != 0 and (i, j) != (0, 0):
            continue
        if i > 0 and list_map[i-1][j] != -1:
            list_map[i][j] += list_map[i-1][j]
        if j > 0 and list_map[i][j-1] != -1:
            list_map[i][j] += list_map[i][j-1]
        
        if i+1 < n and list_map[i+1][j] != -1:
            li.append((i+1, j))
        if j+1 < m and list_map[i][j+1] != -1:
            li.append((i, j+1))
    return list_map[-1][-1]  % 1000000007


if __name__ == '__main__':
    m = 4
    n = 3
    puddles = [[2, 2]]
    print(solution(m, n, puddles))
