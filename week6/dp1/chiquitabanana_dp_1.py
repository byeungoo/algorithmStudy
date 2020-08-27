def solution(N, number):
    
    # while True:
    #     if li[i][0] > 8:
    #         return -1
    #     if li[i][1] == number:
    #         return li[i][0]
    #     li.append((li[i][0] + 1, li[i][1] + N))
    #     li.append((li[i][0] + 1, li[i][1] - N))
    #     li.append((li[i][0] + 1, N - li[i][1]))
    #     li.append((li[i][0] + 1, li[i][1] // N))
    #     if li[i][1] != 0:
    #         li.append((li[i][0] + 1, N // li[i][1]))
    #     li.append((li[i][0] + 1, li[i][1] * N))
    #     i += 1
    
    # 몇시간 붙들고있다가 풀이봤어용 ㅠ.ㅠ

    s = [{N}]
    answer = -1

    for i in range(1, 8):
        s.append({int(str(N)*(i+1))})
        if i == 8:
            break
        for j in range(i):
            for num1 in s[j]:
                for num2 in s[i-j-1]:
                    s[i].add(num1 + num2)
                    s[i].add(num1 - num2)
                    s[i].add(num1 * num2)
                    if num2 != 0:
                        s[i].add(num1 / num2)
        if number in s[i]:
            answer = i + 1
            break
    
    return answer


if __name__ == '__main__':
    N = 5
    number = 12
    
    print(solution(N, number))