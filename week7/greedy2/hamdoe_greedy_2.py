def solution(number, k):
    # 5초..
    # rnum = 0
    # idx = 0
    # while True:
    #     if number[idx] < number[(idx+1)%len(number)]:
    #         number = number.replace(number[idx], '', 1)
    #         if idx: idx -= 1
    #         rnum += 1
    #     else:
    #         idx = (idx + 1) % len(number)
    #     if rnum == k:
    #         break
    # return number

    stack = []
    for num in number:
        while stack and stack[-1] < num and k > 0:
            stack.pop()
            k -= 1
        stack.append(num)
    if k:
        stack = stack[:-k]
    return ''.join(stack)

if __name__ == '__main__':
    list_number = ['1924','1231234','4177252841']
    list_k = [2,3,4]
    list_answer = ['94','3234','775841']
    
    for number, k, answer in zip(list_number, list_k, list_answer):
        assert answer == solution(number, k)