def solution(array, commands):
    answer = []
    
    for com in commands:    
        num = sorted(array[com[0]-1:com[1]])[com[2]-1]
        answer.append(num)
        
    return answer