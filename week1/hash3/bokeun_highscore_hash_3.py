def solution(clothes):
    answer = 1

    clothesMap = {}

    for c in clothes:
        if c[1] not in clothesMap:
            clothesMap[c[1]] = [c[0]]
        else:
            clothesMap[c[1]].append(c[0])

    for k in clothesMap.keys():
        answer *= len(clothesMap[k]) + 1

    answer -= 1

    return answer



c1 = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
c2 = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]

print(solution(c1))
print(solution(c2))
