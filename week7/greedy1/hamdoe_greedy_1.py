def solution(n, lost, reserve):
    inter = set(reserve) & set(lost)
    reserve = list(set(reserve) - inter)
    lost = list(set(lost) - inter)
    rnum = 0
    
    for num in lost:
        if num - 1 in reserve:
            rnum += 1
            reserve.remove(num - 1)
        elif num + 1 in reserve:
            rnum += 1
            reserve.remove(num + 1)

    print(f'lost ::: {lost}')
    print(f'reserve ::: {reserve}')

    return n - len(lost) + rnum


if __name__ == '__main__':
    list_n = [5, 5, 3]
    list_lost = [[2, 4],[2, 4],[3]]
    list_reserve = [[1, 3, 5],[3],[1]]

    for n, lost, reserve in zip(list_n, list_lost, list_reserve):
        print(solution(n, lost, reserve))