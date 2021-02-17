def solution(msg):
    answer = []

    dictionary = {}
    for i in range(26):
        dictionary[chr(i + 65)] = i + 1

    v = 27
    ptr = 0
    w_length = 1
    while ptr < len(msg):
        w = msg[ptr:ptr + w_length]
        c = msg[ptr + w_length:ptr + w_length + 1]
        if c == "":
            answer.append(dictionary[w])
            break
        if w in dictionary and w + c not in dictionary:
            answer.append(dictionary[w])
            dictionary[w + c] = v
            v += 1
            ptr += w_length
            w_length = 1
            continue
        w_length += 1

    return answer


m1 = "KAKAO"
m2 = "TOBEORNOTTOBEORTOBEORNOT"
m3 = "ABABABABABABABAB"

print(solution(m1))
print(solution(m2))
print(solution(m3))
