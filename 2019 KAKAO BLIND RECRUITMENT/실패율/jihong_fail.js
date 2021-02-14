function solution(N, stages) {
    const answer = [];
    const tries = Array(N + 2).fill(0);
    const fails = Array(N + 2).fill(0);

    stages.forEach((stage) => {
        fails[stage] += 1;
        for (let i = stage; i > 0; i--) {
            tries[i] += 1;
        }
    });

    for (let i = 1; i < N + 1; i++) {
        answer.push([i, fails[i] / tries[i]]);
    }

    return answer
        .sort((a, b) => {
            if (a[1] !== b[1]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        })
        .map((v) => v[0]);
}

console.log(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]));
console.log(solution(4, [4, 4, 4, 4, 4]));
