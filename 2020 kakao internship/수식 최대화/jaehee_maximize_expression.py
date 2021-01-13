from itertools import permutations

def solution(expression):
    answer = 0
    org_num_list = []
    org_op_list = []
    tmp_num = ''

    for char in expression:
        if char.isnumeric():
            tmp_num += char
        else:
            org_num_list.append(int(tmp_num))
            org_op_list.append(char)
            tmp_num = ''
    org_num_list.append(int(tmp_num))

    ps = permutations(list(set(org_op_list)))
    # permutation 순회
    for p in ps:
        num_list = org_num_list[:]
        op_list = org_op_list[:]
        # operation 순회
        for cur_op in p:
            tmp_num_list = [num_list[0]]
            tmp_op_list = []
            # 연산 리스트 순회
            for j, op in enumerate(op_list):
                if cur_op == op:
                    num = tmp_num_list.pop()
                    tmp_num_list.append(calc(cur_op, num, num_list[j+1]))
                else:
                    tmp_num_list.append(num_list[j+1])
                    tmp_op_list.append(op)
            num_list = tmp_num_list[:]
            op_list = tmp_op_list[:]
        answer = max(answer, abs(num_list[0]))
    return answer

def calc(op, a, b):
    if op == '*':
        return a * b
    elif op == '+':
        return a + b
    else:
        return a - b

if __name__ == '__main__':
    expressions = [
        "100-200*300-500+20",
        "50*6-3*2"
    ]

    for expression in expressions:
        solution(expression)