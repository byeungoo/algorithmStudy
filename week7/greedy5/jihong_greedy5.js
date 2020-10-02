function solution(n, costs) {
    const uf = new Array(n).fill(0).map((v, i) => i);
    return costs
        .sort((a, b) => a[2] - b[2])
        .reduce((acc, cur) => {
            const node1 = find(uf, cur[0]);
            const node2 = find(uf, cur[1]);

            if (node1 !== node2) {
                node1 < node2 ? (uf[node2] = node1) : (uf[node1] = node2);
                acc += cur[2];
            }
            console.log(cur, uf);
            return acc;
        }, 0);

    function find(parent, a) {
        if (parent[a] === a) {
            return a;
        }

        return find(parent, parent[a]);
    }
}

console.log(
    solution(4, [
        [0, 1, 1],
        [0, 2, 2],
        [1, 2, 5],
        [1, 3, 1],
        [2, 3, 8],
    ])
);

console.log(
    solution(5, [
        [0, 1, 5],
        [1, 2, 3],
        [2, 3, 3],
        [3, 1, 2],
        [3, 0, 4],
        [2, 4, 6],
        [4, 0, 7],
    ])
);
