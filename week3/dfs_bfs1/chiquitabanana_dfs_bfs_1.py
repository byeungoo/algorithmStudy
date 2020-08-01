from itertools import product

def solution(numbers, target):
#     def dfs(idx, is_plus, sum):
#         if idx == len(numbers):
#             return sum == target
#         return dfs(idx+1, True, sum + numbers[idx]) + dfs(idx+1, False, sum - numbers[idx])

#     return dfs(0, True, 0)

    l = [(x, -x) for x in numbers]
    s = list(map(sum, product(*l)))
    return s.count(target)