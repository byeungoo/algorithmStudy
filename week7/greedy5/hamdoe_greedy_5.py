def solution(n, costs):
    answer = 0
    nodes = [i for i in range(n)]
    costs.sort(key = lambda x: x[2])
    for cost in costs:
        if nodes[cost[0]] != nodes[cost[1]]:
            answer += cost[2]
            group = nodes[cost[0]] if nodes[cost[0]] < nodes[cost[1]] else nodes[cost[1]]
            target = nodes[cost[0]] if nodes[cost[0]] > nodes[cost[1]] else nodes[cost[1]]

            # target에 해당하는 모든 node를 바꿔줘야 한다.
            for i, node in enumerate(nodes):
                if node == target:
                    nodes[i] = group
        
    return answer


if __name__ == '__main__':
    n = 5
    costs = [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]
    print(solution(n, costs))