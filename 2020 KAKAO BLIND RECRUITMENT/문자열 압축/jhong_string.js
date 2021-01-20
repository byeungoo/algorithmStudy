function solution(s) {
    var answer = s.length;

    if (answer === 1) {
        return answer;
    }
    for (let i = 1; i <= Math.ceil(s.length / 2); i++) {
        let tmpAnswer = "";
        let prev = s.slice(0, i);
        let cnt = 1;

        for (let j = i; j < s.length; j += i) {
            let curStr = s.slice(j, j + i);
            // console.log("prev", prev);
            // console.log("curr", curStr, i, j);

            if (curStr == prev) {
                cnt += 1;
            } else {
                tmpAnswer =
                    cnt != 1 ? tmpAnswer + cnt + prev : tmpAnswer + prev;
                prev = curStr;
                cnt = 1;
            }

            if (j + i >= s.length) {
                tmpAnswer =
                    cnt != 1 ? tmpAnswer + cnt + prev : tmpAnswer + prev;
            }

            // console.log("tmp", tmpAnswer);
        }

        answer = answer < tmpAnswer.length ? answer : tmpAnswer.length;
    }

    return answer;
}

console.log(solution("a"));
console.log(solution("ababcdcdababcdcd"));
// console.log(solution("abcabcdede"));
// console.log(solution("abcabcabcabcdededededede"));
// console.log(solution("xababcdcdababcdcd"));
