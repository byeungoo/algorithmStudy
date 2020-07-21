def solution(phone_book):
    sort_list = sorted(phone_book)
    # print(sort_list)
    answer = True

    for idx, phone_num in enumerate(sort_list):
        if idx == len(sort_list)-1:
            break

        if sort_list[idx] in sort_list[idx+1]:
            answer = False
            break

    # print(answer)
    return answer
