function solution(n, edge) {
    const adjListMap = new Map();
    const queue = [1];
    const visit = Array(n + 1).fill(0);

    // 인접리스트 만들기
    for (let i = 0; i < edge.length; i++) {
        const [a, b] = edge[i];

        if (!adjListMap.get(a)) {
            adjListMap.set(a, new Set());
        }

        if (!adjListMap.get(b)) {
            adjListMap.set(b, new Set());
        }

        adjListMap.get(a).add(b);
        adjListMap.get(b).add(a);
    }

    // max값 체크
    let max = -1;

    // BFS 시작
    while (queue.length > 0) {
        const head = queue.shift();
        const nextNodes = [...adjListMap.get(head)]
            .filter((v) => visit[v] === 0 && v !== 0 && v !== 1)
            .forEach((v) => {
                visit[v] += visit[head] + 1;
                queue.push(v);

                if (max < visit[v]) max = visit[v];
            });
    }

    // console.log(max);
    // console.log(adjListMap);

    // 배열에서 max 값 가진 애들 개수 세서 리턴
    return visit.filter((v) => v === max).length;
}

console.log(
    solution(6, [
        [3, 6],
        [4, 3],
        [3, 2],
        [1, 3],
        [1, 2],
        [2, 4],
        [5, 2],
    ])
);
