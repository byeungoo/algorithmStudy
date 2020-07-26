from itertools import permutations


def solution(numbers):
    nums_to_check = []
    for i in range(1, len(numbers) + 1):
        nums_to_check += list(map(''.join, permutations(list(numbers), i)))

    prime_numbers = []
    for n in nums_to_check:
        if check_prime_number(n) == True:
            if int(n) not in prime_numbers:
                prime_numbers.append(int(n))

    return len(prime_numbers)


def check_prime_number(number):
    number = int(number)

    if number == 1 or (number % 2 == 0 and number != 2):
        return False

    if number == 2:
        return True

    for i in range(3, number, 2):
        if number % i == 0:
            return False

    return True


print(solution("17"))
print(solution("011"))
