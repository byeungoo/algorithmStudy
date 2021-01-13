function solution(gems) {
    const gemSet = new Set(gems);
    const checkSet = new Set();

    console.log(gemSet);
    let start = gems.length - 2;
    let end = gems.length - 1;
    let dist = 100001;
    let tmpStart = start;
    let tmpEnd = end;

    checkSet.add(gems[end]);

    if (gemSet.size === 1) {
        return [1, 1];
    }
    while (start >= 0) {
        if (start === end) {
            start -= 1;
        }
        console.log(start, end);
        if (gems[start] !== gems[end]) {
            checkSet.add(gems[start]);

            if (checkSet.size === gemSet.size) {
                if (dist > end - start) {
                    dist = end - start;
                    tmpStart = start;
                    tmpEnd = end;
                }
            }
            start -= 1;
            console.log("a", start, end);
        } else {
            end -= 1;
            while (gems[end] === gems[end - 1] && start < end) {
                end -= 1;
            }
            // console.log("b", start, end);
        }
    }

    // console.log(dist);
    if (dist > end - start) {
        dist = end - start;
        tmpStart = start;
        tmpEnd = end;
    }

    return [tmpStart + 1, tmpEnd + 1];
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
