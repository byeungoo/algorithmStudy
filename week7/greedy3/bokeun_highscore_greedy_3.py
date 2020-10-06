def solution(name):
    answer = 0

    current = "A" * len(name)
    idx = 0
    while True:
        button = ord(name[idx]) - ord('A')
        if button > 13:
            button = 26 - button
        answer += button
        current = current[:idx] + name[idx] + current[idx + 1:]

        if current == name:
            break

        r_idx, l_idx = idx, idx
        r_distance, l_distance = 0, 0
        while True:
            r_idx += 1
            r_idx = idx_reorganaizer(r_idx, name)
            r_distance += 1
            if current[r_idx] != name[r_idx]:
                break
        while True:
            l_idx -= 1
            l_idx = idx_reorganaizer(l_idx, name)
            l_distance += 1
            if current[l_idx] != name[l_idx]:
                break

        if r_distance <= l_distance:
            idx = r_idx
            answer += r_distance
        else:
            idx = l_idx
            answer += l_distance

    return answer


def idx_reorganaizer(idx, name):
    if idx < 0:
        idx = len(name) + idx
    elif idx >= len(name):
        idx = 0

    return idx


n1 = "JEROEN"
n2 = "JAN"
n3 = "ADFECBFAERFADFAS"
n4 = "BBBAAAB"
n5 = "ABABAAAAABA"

print(solution(n1))
print(solution(n2))
print(solution(n3))
print(solution(n4))
print(solution(n5))
