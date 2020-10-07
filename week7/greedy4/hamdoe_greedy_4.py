def solution(people, limit):
    answer = 0
    people.sort()
    left = 0
    right = len(people)-1
    
    while True:
        if limit - people[right] >= people[left]:
            left += 1
            right -= 1
            answer += 1
        else:
            right -= 1
            answer += 1
        if left > right:
            break

    return answer

if __name__ == '__main__':
    list_people = [[70,50,80,50],[70,50,80]]
    list_limit = [100,100]

    for people, limit in zip(list_people, list_limit):
        print(solution(people, limit))