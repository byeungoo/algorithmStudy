def solution(name):
    answer = 0
    l = len(name)
    list_idx = []
    for idx, char in enumerate(name):
        if char != 'A':
            list_idx.append(idx)
            answer += min(ord(name[idx])-ord('A'), (ord('Z')+1-ord(name[idx])))

    curr_idx = 0
    min_idx = 0
    min_dist = 20
    while list_idx:
        for idx in list_idx:
            if curr_idx < idx:
                dist = min(idx - curr_idx, curr_idx + (l - idx))
            else:
                dist = curr_idx - idx
            if dist < min_dist:
                min_dist = dist
                min_idx = idx
        list_idx.remove(min_idx)
        curr_idx = min_idx
        answer += min_dist
        min_dist = 20
            
    return answer


if __name__ == '__main__':
    list_name = ['JEROEN','JAN']
    for name in list_name:
        print(f'answer ::: {solution(name)}')