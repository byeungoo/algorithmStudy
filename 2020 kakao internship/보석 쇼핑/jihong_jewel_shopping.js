function solution(gems) {
    const gemSet = new Set(gems);
    const checkSize = gemSet.size;
    const gemMap = new Map();

    let start = 0;
    let end = 1;
    const answer = [0, gems.length];
    gemMap.set(gems[0], 1);

    while (end < gems.length && start < gems.length) {
        if (start >= end) {
            end += 1;
        }

        if (gemMap.size === checkSize) {
            if (end - start < answer[1] - answer[0]) {
                answer[1] = end;
                answer[0] = start;
            }

            if (gemMap.get(gems[start]) > 0) {
                gemMap.set(gems[start], gemMap.get(gems[start]) - 1);

                if (gemMap.get(gems[start]) === 0) {
                    gemMap.delete(gems[start]);
                }
                start += 1;
            }
        } else {
            if (!gemMap.has(gems[end])) {
                gemMap.set(gems[end], 1);
            } else {
                gemMap.set(gems[end], gemMap.get(gems[end]) + 1);
            }

            end += 1;

            if (end === gems.length) {
                while (start < gems.length && gemMap.size === checkSize) {
                    if (end - start < answer[1] - answer[0]) {
                        answer[1] = end;
                        answer[0] = start;
                    }

                    if (gemMap.get(gems[start]) > 0) {
                        gemMap.set(gems[start], gemMap.get(gems[start]) - 1);

                        if (gemMap.get(gems[start]) === 0) {
                            gemMap.delete(gems[start]);
                        }
                        start += 1;
                    }
                }
            }
        }
    }

    answer[0] += 1;
    return answer;
}

console.log(
    solution([
        "DIA",
        "RUBY",
        "RUBY",
        "DIA",
        "DIA",
        "EMERALD",
        "SAPPHIRE",
        "DIA",
    ])
);
console.log(solution(["AA", "AB", "AC", "AA", "AC"]));
console.log(solution(["XYZ", "XYZ", "XYZ"]));
console.log(solution(["ZZZ", "YYY", "NNNN", "YYY", "BBB"]));
console.log(solution(["DIA", "EM", "EM", "RUB", "DIA"]));
