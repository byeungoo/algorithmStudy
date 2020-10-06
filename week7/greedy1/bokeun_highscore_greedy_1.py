def solution(n, lost, reserve):
    set_reserve = set(reserve) - set(lost)
    set_lost = set(lost) - set(reserve)

    borrow = 0
    for l in set_lost:
        if l - 1 in set_reserve:
            set_reserve.remove(l - 1)
            borrow += 1
        elif l + 1 in set_reserve:
            set_reserve.remove(l + 1)
            borrow += 1

    answer = n - len(set_lost) + borrow

    return answer


n1 = 5
l1 = [2, 4]
r1 = [1, 3, 5]
n2 = 5
l2 = [2, 4]
r2 = [3]
n3 = 3
l3 = [3]
r3 = [1]
n4 = 5
l4 = [2, 4]
r4 = [1, 3]
n5 = 5
l5 = [2, 4]
r5 = [3, 5]
n6 = 5
l6 = [2, 4]
r6 = [2, 4]

print(solution(n1, l1, r1))
print(solution(n2, l2, r2))
print(solution(n3, l3, r3))
print(solution(n4, l4, r4))
print(solution(n5, l5, r5))
print(solution(n6, l6, r6))
