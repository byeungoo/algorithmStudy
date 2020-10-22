function solution(arrows) {
    let answer = 0;
    let nextPos = {};

    /**
     * vistMap 구조
     * Map <key : 현재 위치의 x 값,
     *      value :
     *          Map < key: 현재위치의 y 값,
     *                value:
     *                  Set <value: 현재위치에서 나가는 방향>
     *               >
     *     >
     *
     * ex)
     *  Map( 0 , Map(0, Set(3,2,4) ))
     */
    const visitMap = new Map();

    for (let i = 0; i < arrows.length; i++) {
        // 대각선 크로스 되는 경우를 체크하기 위해 이동거리를 두배로 만든다고 합니다.......ㅅㅂ....
        for (let j = 0; j < 2; j++) {
            const curPos = i === 0 && j === 0 ? { x: 0, y: 0 } : nextPos;
            const dir = arrows[i];
            let isNew = false;

            if (!visitMap.get(curPos.x)) {
                visitMap.set(curPos.x, new Map());
            }

            if (!visitMap.get(curPos.x).get(curPos.y)) {
                visitMap.get(curPos.x).set(curPos.y, new Set());
            }

            if (!visitMap.get(curPos.x).get(curPos.y).has(dir)) {
                visitMap.get(curPos.x).get(curPos.y).add(dir);
                isNew = true;
            }

            // 다음에 갈 위치
            nextPos = getNextPosition(curPos, dir);
            // 다음에 갈 위치에 방문한적이 있고,
            // 현재 위치에서 다음 위치로 가는 방향이 중복되지 않고,
            // 다음 위치에서 현재위치로 역으로 오는 경우가 없으면
            if (isVisit(nextPos) && isNew && !checkRevDirection(nextPos, dir)) {
                answer += 1;
            }
        }
    }

    return answer;

    function getNextPosition(curPos, direction) {
        const nextNode = { ...curPos };
        switch (direction) {
            case 0:
                nextNode.y -= 1;
                break;
            case 1:
                nextNode.x += 1;
                nextNode.y -= 1;
                break;
            case 2:
                nextNode.x += 1;
                break;
            case 3:
                nextNode.x += 1;
                nextNode.y += 1;
                break;
            case 4:
                nextNode.y += 1;
                break;
            case 5:
                nextNode.x -= 1;
                nextNode.y += 1;
                break;
            case 6:
                nextNode.x -= 1;
                break;
            case 7:
                nextNode.x -= 1;
                nextNode.y -= 1;
                break;
            default:
                break;
        }

        return nextNode;
    }

    function isVisit(curPos) {
        return visitMap.has(curPos.x) && visitMap.get(curPos.x).has(curPos.y);
    }

    // 역방향 체크
    function checkRevDirection(curPos, dir) {
        const reverseDir = (dir + 4) % 8;
        return (
            visitMap.has(curPos.x) &&
            visitMap.get(curPos.x).has(curPos.y) &&
            visitMap.get(curPos.x).get(curPos.y).has(reverseDir)
        );
    }
}

console.log(solution([6, 2, 6, 2, 6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0]));
console.log(solution([6, 4, 2, 0]));
console.log(solution([6, 2, 6, 2]));
console.log(solution([6, 6, 6, 2, 2, 2]));
console.log(solution([0, 2, 5, 0, 3]));
console.log(solution([6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 5, 5, 5, 0, 0, 0, 3, 3, 3]));
console.log(solution([6, 6, 3, 3, 0, 0, 6, 6, 3, 3, 0, 0]));
