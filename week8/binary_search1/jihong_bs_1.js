function solution(n, times) {
    let low = 0;
    let high = times.reduce((max, cur) => (max < cur ? cur : max)) * n;
    let mid = Math.floor((low + high) / 2);

    while (low <= high) {
        const tmpCount = times.reduce(
            (acc, cur) => acc + Math.floor(mid / cur),
            0
        );

        if (n <= tmpCount) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }

        mid = Math.floor((low + high) / 2);
    }

    return low;
}

console.log(solution(6, [7, 10]));
