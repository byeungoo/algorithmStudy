function solution(relation) {
    var answer = 0;
    const keyLength = relation[0].length;

    const keys = Array(keyLength)
        .fill(0)
        .map((v, i) => i);

    const uniqueKey = keys
        .map((v, i) => comb(keys, i + 1))
        .flat()
        .filter((v) => isPrimaryKey(v));

    const primaryKey = uniqueKey.filter((v, idx) => {
        for (let i = 0; i < uniqueKey.length; i++) {
            if (i !== idx && isSub(v, uniqueKey[i])) {
                return false;
            }
        }
        return true;
    });

    return primaryKey.length;

    function comb(arr, r) {
        const result = [];
        if (r == 1) {
            return arr.map((v) => [v]);
        }

        arr.forEach((v, idx, arr) => {
            const fixed = arr[idx];
            const rest = arr.slice(idx + 1);
            const combArr = comb(rest, r - 1);
            const resultArr = combArr.map((v) => [fixed, ...v]);
            result.push(...resultArr);
        });
        return result;
    }

    function isPrimaryKey(arr) {
        const testSet = new Set();
        relation.forEach((v) => {
            const testStr = arr.reduce((prev, cur) => {
                return prev + v[cur];
            }, "");

            testSet.add(testStr);
        });

        return testSet.size === relation.length;
    }

    function isSub(key, comparedKey) {
        return comparedKey.every((value) => key.includes(value));
    }
}

console.log(
    solution([
        ["100", "ryan", "music", "2"],
        ["200", "apeach", "math", "2"],
        ["300", "tube", "computer", "3"],
        ["400", "con", "computer", "4"],
        ["500", "muzi", "music", "3"],
        ["600", "apeach", "music", "2"],
    ])
);
