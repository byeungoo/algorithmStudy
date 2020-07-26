def solution(citations):
    answer = 0

    citations = sorted(citations)
    n = len(citations)

    for h in range(max(citations)):
        for i in range(n):
            if citations[i] >= h and n - i >= h:
                answer = h

    return answer


c1 = [3, 0, 6, 1, 5]
print(solution(c1))
c2 = [5, 5, 5, 5]  # -> h= 4
print(solution(c2))
