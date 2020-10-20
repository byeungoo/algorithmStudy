function solution(arrows) {
    let answer;
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
        const curPos = i === 0 ? { x: 0, y: 0 } : nextPos;
        const dir = arrows[i];

        nextPos = getNextPostion(curPos, dir);
        if (isVisit(curPos)) console.log(curPos, isVisit(curPos));

        if (!visitMap.get(curPos.x)) {
            visitMap.set(curPos.x, new Map());
        }

        if (!visitMap.get(curPos.x).get(curPos.y)) {
            visitMap.get(curPos.x).set(curPos.y, new Set());
        }

        visitMap.get(curPos.x).get(curPos.y).add(dir);
    }

    // 마지막 노드 한번 더 체크

    console.log(visitMap);

    return;

    function getNextPostion(curPos, direction) {
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

    function isCrossed(curPos, dir) {}
}

console.log(
    solution([6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0])
);
