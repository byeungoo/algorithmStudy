def solution(routes):
    answer = 0
    routes.sort()
    bf_end = -30001
    for route in routes:
        if route[0] > bf_end:
            # 포함되지 않는 경우
            answer += 1
            bf_end = route[1]
        else:
            # 포함되는 경우
            bf_end = min(bf_end, route[1])
    return answer


if __name__ == "__main__":
    routes = [[-20,15], [-14,-5], [-18,-13], [-5,-3]]
    print(solution(routes))