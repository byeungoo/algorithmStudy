function solution(n, results) {
    const resMap = new Map();

    for (let i = 0; i < results.length; i++) {
        const [win, lose] = results[i];
        if (!resMap.get(win)) {
            resMap.set(win, { win: new Set(), lose: new Set() });
        }

        if (!resMap.get(lose)) {
            resMap.set(lose, { win: new Set(), lose: new Set() });
        }

        resMap.get(win).win.add(lose);
        resMap.get(lose).lose.add(win);
    }

    console.log(resMap);
    for (const [key, value] of resMap.entries()) {
        value.win.forEach((nextWin) => {
            resMap.get(nextWin).win.forEach((v) => {
                value.win.add(v);
            });
        });

        value.lose.forEach((nextLose) => {
            resMap.get(nextLose).lose.forEach((v) => value.lose.add(v));
        });
    }

    console.log(resMap);
    let answer = 0;
    resMap.forEach((value, key) => {
        value.win.size + value.lose.size === n - 1 && answer++;
    });
    return answer;
}

console.log(
    solution(5, [
        [4, 3],
        [4, 2],
        [3, 2],
        [1, 2],
        [2, 5],
    ])
);

console.log(
    solution(8, [
        [1, 2],
        [2, 3],
        [3, 4],
        [5, 6],
        [6, 7],
        [7, 8],
    ])
);
