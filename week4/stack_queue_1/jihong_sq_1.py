def solution(prices):
    answer = [0 for i in range(len(prices))]
    st = []
    time = 0
    for index, price in enumerate(prices):
        if not len(st):
            st.append([price, index])
        else:
            if st[-1][0] <= price:
                st.append([price, index])
            else:
                while len(st) > 0 and st[-1][0] > price:
                    top = st.pop()
                    answer[top[1]] = index - top[1]
                
                st.append([price, index])
        time+=1
        
    while len(st) > 0:
        top = st.pop()
        answer[top[1]] = time - top[1] -1
        
    return answer


print(solution([1, 2, 3, 2, 3]))