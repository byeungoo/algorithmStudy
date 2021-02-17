def solution(n, t, m, p):
    listed = ""
    num = 0
    while len(listed) < t * m:
        listed += rebase(num, n)
        num += 1

    return listed[p - 1::m][:t]


def rebase(n, base):
    rebased = ""
    num_map = {"10": "A", "11": "B", "12": "C", "13": "D", "14": "E", "15": "F"}
    while n > 0:
        mod = str(n % base)
        if mod in num_map:
            mod = num_map[mod]
        rebased += mod
        n //= base
    if rebased == "":
        return "0"

    return rebased[::-1]


n1, t1, m1, p1 = 2, 4, 2, 1
n2, t2, m2, p2 = 16, 16, 2, 1
n3, t3, m3, p3 = 16, 16, 2, 2

print(solution(n1, t1, m1, p1))
print(solution(n2, t2, m2, p2))
print(solution(n3, t3, m3, p3))
