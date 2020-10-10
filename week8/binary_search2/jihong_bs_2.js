function solution(distance, rocks, n) {
    let answer = 0;
    let low = 1;
    let high = distance;

    rocks.sort((a, b) => a - b);

    while (low <= high) {
        let removeNum = n;
        let prev = 0;
        mid = Math.floor((high + low) / 2);
        // console.log(
        //     "str",
        //     "h",
        //     high,
        //     "l",
        //     low,
        //     "m",
        //     mid,
        //     "r",
        //     removeNum,
        //     answer
        // );

        for (let i = 0; i < rocks.length; i++) {
            if (rocks[i] - prev < mid) {
                removeNum--;
            } else {
                prev = rocks[i];
            }
        }

        if (distance - prev < mid) {
            removeNum--;
        }

        if (removeNum < 0) {
            high = mid - 1;
        } else {
            low = mid + 1;
            answer = answer > mid ? answer : mid;
        }

        // console.log(
        //     "end",
        //     "h",
        //     high,
        //     "l",
        //     low,
        //     "m",
        //     mid,
        //     "r",
        //     removeNum,
        //     answer
        // );
    }

    return answer;
}

console.log(solution(25, [2, 14, 11, 21, 17], 2));
