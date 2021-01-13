def solution(gems):
    diversity = len(set(gems))
    left, right = 0, 0

    total_line = len(gems)
    answer = [1, total_line]

    basket = {gems[0]: 1}
    while right < total_line and left < total_line:
        if len(basket) == diversity:
            if right - left < answer[1] - answer[0]:
                answer = [left + 1, right + 1]
            if left == right:
                right += 1
            else:
                basket[gems[left]] -= 1
                if basket[gems[left]] == 0:
                    del basket[gems[left]]
                left += 1
        else:
            if right < total_line - 1:
                right += 1
                if gems[right] not in basket:
                    basket[gems[right]] = 0
                basket[gems[right]] += 1
            else:
                left += 1

    return answer


g1 = ["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]
g2 = ["AA", "AB", "AC", "AA", "AC"]
g3 = ["XYZ", "XYZ", "XYZ"]
g4 = ["ZZZ", "YYY", "NNNN", "YYY", "BBB"]
g5 = ["T"]

print(solution(g1))
print(solution(g2))
print(solution(g3))
print(solution(g4))
print(solution(g5))
