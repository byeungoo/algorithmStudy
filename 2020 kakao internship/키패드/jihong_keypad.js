function solution(numbers, hand) {
    var answer = "";
    let rhPos = [3, 2];
    let lhPos = [3, 0];
    const rightHand = hand === "right";

    const keypadPos = [
        [3, 1],
        [0, 0],
        [0, 1],
        [0, 2],
        [1, 0],
        [1, 1],
        [1, 2],
        [2, 0],
        [2, 1],
        [2, 2],
    ];

    numbers.forEach((n) => {
        if (n === 1 || n === 4 || n === 7) {
            answer += "L";
            lhPos = keypadPos[n];
        } else if (n === 3 || n === 6 || n === 9) {
            answer += "R";
            rhPos = keypadPos[n];
        } else {
            const rDist = calcDistance(n, rhPos);
            const lDist = calcDistance(n, lhPos);

            if (rDist < lDist) {
                answer += "R";
                rhPos = keypadPos[n];
            } else if (rDist > lDist) {
                answer += "L";
                lhPos = keypadPos[n];
            } else {
                if (rightHand) {
                    answer += "R";
                    rhPos = keypadPos[n];
                } else {
                    answer += "L";
                    lhPos = keypadPos[n];
                }
            }
        }
    });

    return answer;

    function calcDistance(n, pos) {
        const [y, x] = keypadPos[n];
        return Math.abs(pos[0] - y) + Math.abs(pos[1] - x);
    }
}

console.log(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"));
console.log(solution([7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2], "left"));
console.log(solution([1, 2, 3, 4, 5, 6, 7, 8, 9, 0], "right"));
