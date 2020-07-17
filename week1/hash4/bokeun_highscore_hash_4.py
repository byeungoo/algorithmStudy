def solution(genres, plays):
    answer = []

    chartMap = {}
    for i in range(len(genres)):
        if genres[i] not in chartMap:
            chartMap[genres[i]] = {}
            chartMap[genres[i]]["count"] = 0
        chartMap[genres[i]][i] = plays[i]
        chartMap[genres[i]]["count"] += plays[i]

    for k in chartMap.keys():
        chartMap[k] = sorted(chartMap[k].items(), reverse=True, key=lambda x:x[1])

    sortedMap = sorted(chartMap.items(), reverse=True, key=lambda x:x[1][0][1])
    for s in sortedMap:
        try:
            answer.append(s[1][1][0])
            answer.append(s[1][2][0])
        except:
            pass

    return answer


g1 = ["classic", "pop", "classic", "classic", "pop"]
p1 = [500, 600, 150, 800, 2500]


print(solution(g1, p1))