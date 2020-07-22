from itertools import permutations

def is_prime(number):
    if number == 1 or number == 0:
        return False
    for i in range(2, number):
        if number % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    l = set()
    for i in range(len(numbers)):
        tmp = [int(''.join(list(num))) for num in permutations(numbers, i+1)]
        l.update(tmp)
    for num in l:
        answer += is_prime(num)
    return answer