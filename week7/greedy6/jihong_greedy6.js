function solution(routes) {
    return routes
        .map((v) => {
            return { start: v[0], end: v[1] };
        })
        .sort((a, b) => a.start - b.start)
        .reduce((acc, cur) => {
            const tmp = [];
            if (!acc.length) {
                acc.push(cur);
            }

            for (let i = 0; i < acc.length; i++) {
                if (acc[i].start <= cur.end && acc[i].end >= cur.start) {
                    acc[i].start =
                        acc[i].start >= cur.start ? acc[i].start : cur.start;
                    acc[i].end = acc[i].end <= cur.end ? acc[i].end : cur.end;
                    return acc;
                }
            }

            acc.push(cur);
            return acc;
        }, []).length;
}

console.log(
    solution([
        [-5, -3],
        [-18, -13],
        [-20, 15],
        [-14, -5],
    ])
);
