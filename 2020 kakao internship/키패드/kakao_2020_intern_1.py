def solution(numbers, hand):
    answer = ''

    hand_by_button = {"1": "L", "4": "L", "7": "L", "3": "R", "6": "R", "9": "R", "left": "L", "right": "R"}
    pos_by_button = {"1": [0, 0], "2": [0, 1], "3": [0, 2], "4": [1, 0], "5": [1, 1], "6": [1, 2], "7": [2, 0],
                     "8": [2, 1], "9": [2, 2], "*": [3, 0], "0": [3, 1], "#": [3, 2],
                     }

    cur_right = "#"
    cur_left = "*"

    for n in numbers:
        num = str(n)
        if num in hand_by_button.keys():
            answer += hand_by_button[num]
            if hand_by_button[num] == "L":
                cur_left = num
            else:
                cur_right = num
        else:
            dist_from_right = abs(pos_by_button[cur_right][0] - pos_by_button[num][0]) + abs(pos_by_button[cur_right][1] - pos_by_button[num][1])
            dist_from_left = abs(pos_by_button[cur_left][0] - pos_by_button[num][0]) + abs(pos_by_button[cur_left][1] - pos_by_button[num][1])

            if dist_from_left < dist_from_right:
                cur_left = num
                answer += "L"
            elif dist_from_left > dist_from_right:
                cur_right = num
                answer += "R"
            else:
                if hand == "left":
                    cur_left = num
                    answer += "L"
                else:
                    cur_right = num
                    answer += "R"

    return answer


n1 = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
h1 = "right"
n2 = [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]
h2 = "left"
n3 = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]
h3 = "right"

print(solution(n1, h1))
print(solution(n2, h2))
print(solution(n3, h3))
