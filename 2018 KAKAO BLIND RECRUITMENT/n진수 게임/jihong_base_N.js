function solution(n, t, m, p) {
    return [...n_base(n, t * m)]
        .filter((_, i) => i % m === p - 1)
        .filter((_, i) => i < t)
        .join("");

    function n_base(base, max) {
        let nBaseStr = "0";
        const hexDic = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, "A", "B", "C", "D", "E", "F"];

        for (let i = 0; i < max; i++) {
            let tempStr = "";
            let n = i;

            while (n > 0) {
                const r = n % base;
                tempStr += String(hexDic[r]);
                n = Math.floor(n / base);
            }

            nBaseStr += [...tempStr].reverse().join("");
        }

        return nBaseStr;
    }
}

console.log(solution(2, 4, 2, 1));
console.log(solution(16, 16, 2, 1));
console.log(solution(16, 16, 2, 2));
