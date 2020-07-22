from functools import cmp_to_key

def compare(x, y):
    xy = int(x + y)
    yx = int(y + x)
    return yx - xy

def solution(numbers):
    snum = sorted(list(map(str, numbers)), key=cmp_to_key(compare))
    answer = str(int(''.join(snum)))
    return answer