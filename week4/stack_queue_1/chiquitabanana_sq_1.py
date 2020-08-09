def solution(prices):
    answer = [0 for i in range(len(prices))]
    
    # (index, price) tuple을 저장하는 stack
    ps = []
    
    for i, p in enumerate(prices):
        while ps:
            # stack의 마지막 원소 price와 p 비교
            if ps[-1][1] > p:

                # 가격이 떨어진 경우 초 저장, pop
                answer[ps[-1][0]] = i - ps[-1][0]
                ps.pop()
            else:
                break

        # 가격 비교를 마치고 나서 stack에 추가
        ps.append((i, p))
    
    # 끝까지 가격이 떨어지지 않은 경우
    while ps:
        answer[ps[-1][0]] = i - ps[-1][0]
        ps.pop()
            
    return answer