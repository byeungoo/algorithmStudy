def solution(people, limit):
    answer = 0

    people.sort()

    left, right = 0, len(people) - 1

    while left <= right:
        weight_on_boat = 0
        weight_on_boat += people[right]

        while weight_on_boat + people[left] <= limit:
            weight_on_boat += people[left]
            left += 1

        answer += 1
        right -= 1

    return answer


p1 = [70, 50, 80, 50]
l1 = 100
p2 = [70, 80, 50]
l2 = 100

print(solution(p1, l1))
print(solution(p2, l2))
