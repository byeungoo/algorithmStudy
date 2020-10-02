function solution(people, limit) {
    return people
        .sort((a, b) => b - a)
        .reduce((acc, cur, i, arr) => {
            if (cur + arr[arr.length - 1] <= limit) {
                arr.pop();
            }
            return ++acc;
        }, 0);
}

console.log(solution([70, 50, 80, 50], 100));
