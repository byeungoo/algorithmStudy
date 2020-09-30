def solution(money):
    li1 = [money[0], max(money[0],money[1])]
    li2 = [0, money[1]]
    n = len(money)
    for i in range(2, n):
        if i == n-1:
            li1.append(max(li1[i-2], li1[i-1]))
            li2.append(max(li2[i-2]+money[i], li2[i-1]))
        else:
            li1.append(max(li1[i-2]+money[i], li1[i-1]))
            li2.append(max(li2[i-2]+money[i], li2[i-1]))
    return max(li1[n-1], li2[n-1])


if __name__ == '__main__':
    money = [1,2,3,1]
    print(solution(money))