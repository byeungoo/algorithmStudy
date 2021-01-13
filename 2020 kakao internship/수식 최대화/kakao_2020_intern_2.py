from itertools import permutations


def solution(expression):
    answer = 0

    operators = ["+", "-", "*"]

    # 순열로 우선순위 맵 생성
    priorities = dict()
    for i, p in enumerate(permutations(operators, 3)):
        priorities[i] = list(p)

    # 중위표기 문자열 수식을 리스트형 수식으로 변
    infix = list()
    ptr = 0
    for i, e in enumerate(expression):
        if e in operators:
            infix.append(expression[ptr:i])
            infix.append(expression[i])
            ptr = i + 1
    infix.append(expression[ptr:])

    # 각 우선순위별로 최대값 계산
    for priority in priorities.values():

        # 중위표기 리스트형 수식을 후위 리스트형 수식으로 변경
        postfix, stack = list(), list()
        for e in infix:
            if e not in operators:
                postfix.append(e)
            else:
                while len(stack) != 0 and priority.index(stack[-1]) <= priority.index(e):
                    postfix.append(stack.pop())
                stack.append(e)
        while len(stack) != 0:
            postfix.append(stack.pop())

        # 후위표기 리스트에 대한 계산 수
        stk = list()
        for e in postfix:
            if e not in operators:
                stk.append(e)
            else:
                stk.append(calculator(e, int(stk.pop()), int(stk.pop())))

        # 상금 절대값 비교 후 최대값 세
        reward = abs(stk.pop())
        if reward > answer:
            answer = reward

    return answer


def calculator(op: str, num1: int, num2: int):
    if op == "+":
        result = num1 + num2
    elif op == "-":
        result = num2 - num1
    else:
        result = num1 * num2

    return result


e1 = "100-200*300-500+20"
e2 = "50*6-3*2"

print(solution(e1))
print(solution(e2))
