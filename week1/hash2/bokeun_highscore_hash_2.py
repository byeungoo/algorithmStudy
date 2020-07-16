def solution(phone_book):
    answer = True
    map = {}
    phone_book = sorted(phone_book)

    for pn in phone_book:
        for i in range(len(pn)):
            if pn[0:i+1] not in map:
               map[pn[0:i+1]] = pn
            else:
                if pn[0:i+1] == map[pn[0:i+1]]:
                    answer = False
                    break
        if answer == False:
            break

    return answer

tc1 = ["119", "97674223", "1195524421"]
tc2 = ["123", "456", "789"]
tc3 = ["125", "12"]

print(solution(tc1))
print(solution(tc2))
print(solution(tc3))
