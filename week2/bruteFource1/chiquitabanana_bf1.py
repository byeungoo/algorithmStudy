def solution(answers):
    supo = [[1,2,3,4,5],
            [2,1,2,3,2,4,2,5],
            [3,3,1,1,2,2,4,4,5,5]]
    
    count = [0,0,0]
    
    for i, ans in enumerate(answers):
        for j, l in enumerate(supo):
            if ans == supo[j][i%len(l)]:
                count[j] += 1
    
    max_score = max(count)
    answer = [i+1 for i, c in enumerate(count) if max_score == c]
    
    return sorted(answer)