import math

def solution(numbers, hand):
    '''
        1. 숫자별 위치 필요
            x: num - 1 // 3
            y: num % 3 - 1
            단, 0, *, #은 직접 삽입
        2. 숫자 누를때마다 왼손 오른손 위치 저장
        3. 1, 4, 7/3, 6, 9는 룰베이스
        4. 2, 5, 8, 0인 경우 거리 계산
    '''
    answer = ''
    xy = {num: ((num-1)//3, (num-1)%3) for num in range (1, 10)}
    xy['*'], xy[0], xy['#'] = (3, 0), (3, 1), (3, 2)
    left, right = xy['*'], xy['#']
    
    for number in numbers:
        if number in (1, 4, 7):
            answer += 'L'
            left = xy[number]
        elif number in (3, 6, 9):
            answer += 'R'
            right = xy[number]
        else:
            left_dist = calc_dist(left, xy[number])
            right_dist = calc_dist(right, xy[number])
            if left_dist < right_dist:
                answer += 'L'
                left = xy[number]
            elif left_dist > right_dist:
                answer += 'R'
                right = xy[number]
            else:
                if hand == 'left':
                    answer += 'L'
                    left = xy[number]
                else:
                    answer += 'R'
                    right = xy[number]

    return answer

def calc_dist(a, b):
    return abs(a[0] - b[0]) + abs(a[1] - b[1])


if __name__ == '__main__':
    inputs = [
        ([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"),
        ([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"),
        ([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right")
    ]
    for numbers, hand in inputs:
        solution(numbers, hand)