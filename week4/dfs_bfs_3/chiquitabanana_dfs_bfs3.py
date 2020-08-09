def solution(begin, target, words):
    if target not in words:
        return 0
    
    words.append(begin)
    n = len(words)

    # words * words 2차원 배열
    path = [[0 for col in range(n)] for row in range(n)]

    for i, w1 in enumerate(words):
        for j, w2 in enumerate(words):
            # w1과 w2가 서로 변환가능한 경우 1
            count = sum(1 for c1, c2 in zip(w1, w2) if c1 != c2)
            if count == 1:
                path[i][j] = 1

    visited = set()          
    next = []
    min_cnt = n

    # 이것도 굳이 nested function으로 할 필요는 없었음..
    def dfs(cur_idx, cur_cnt):
        nonlocal min_cnt

        # target에 도달한 경우 min_cnt 교체
        if words[cur_idx] == target:
            min_cnt = min_cnt if min_cnt < cur_cnt else cur_cnt
            return
        
        # 현재 idx에서 갈 수 있는 경로 탐색
        for i in range(n):
            if path[cur_idx][i] and i not in visited:
                next.append(i)
        if not next:
            return
        idx = next.pop()
        visited.add(idx)
        dfs(idx, cur_cnt + 1)
        visited.discard(idx)
    
    # 가장 마지막에 추가한 begin부터 시작
    visited.add(n-1)
    dfs(n-1, 0)
    
    return min_cnt if min_cnt != n else 0

if __name__ == '__main__':
    begin = 'hit'
    target = 'cog'
    words = ['hot','dot','dog','lot','log','cog']

    print(f'answer ::: {solution(begin, target, words)}')