function solution(msg) {
    const answer = [];
    const msgLen = msg.length;
    const alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const wordDic = new Map();
    let dicIndex = 27;

    [...alphabet].forEach((v, i) => {
        wordDic.set(v, i + 1);
    });

    for (let i = 0; i < msgLen; i++) {
        let curInput = msg[i];
        let nextInput = msg[i];
        let index = i;

        while (index < msgLen && wordDic.has(nextInput)) {
            index += 1;
            curInput = nextInput;
            if (msg[index]) {
                nextInput = nextInput.concat(msg[index]);
            }
        }

        const curIndex = curInput === nextInput ? index : index - 1;

        // console.log("curr", curInput);
        // console.log("next", nextInput);

        if (wordDic.has(curInput)) {
            answer.push(wordDic.get(curInput));
        }
        // console.log("index", index);
        // console.log("index", curIndex);

        wordDic.set(nextInput, dicIndex);

        dicIndex += 1;
        i = curIndex;
    }

    // console.log(wordDic);

    return answer;
}

console.log(solution("KAKAO"));
console.log(solution("KKAKAO"));
console.log(solution("TOBEORNOTTOBEORTOBEORNOT"));
console.log(solution("ABABABABABABABAB"));
