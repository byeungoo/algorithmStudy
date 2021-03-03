function solution(m, musicinfos) {
    var answer = "";
    const newM = changeSharp(m);
    const infos = musicinfos
        .map((v, i) => {
            const [start, end, name, music] = v.split(",");
            const space = hourToMin(start, end);

            const newMusic = changeSharp(music);
            const musicLen = newMusic.length;
            const realMusic = makeRealMusic(newMusic, space, musicLen);

            // console.log("real", realMusic);
            return realMusic.includes(newM) ? [name, space, i] : null;
        })
        .filter((v) => v !== null)
        .sort((a, b) => {
            if (a[1] === b[1]) {
                return a[2] - b[2];
            }
            return b[1] - a[1];
        });

    // console.log(infos);

    return infos.length === 0 ? "(None)" : infos[0][0];

    function hourToMin(start, end) {
        const [startHour, startMin] = start.split(":");
        const [endHour, endMin] = end.split(":");

        return Number(endHour * 60) + Number(endMin) - (Number(startHour * 60) + Number(startMin));
    }

    function makeRealMusic(music, space, musicLen) {
        let realMusic = "";

        for (let i = 0; i < Math.floor(space / musicLen); i++) {
            realMusic += music;
        }

        realMusic = realMusic.concat(music.slice(0, space % musicLen));

        return realMusic;
    }

    function changeSharp(s) {
        const len = s.length;
        const arr = [...s];
        for (let i = 1; i < len; i++) {
            if (arr[i] === "#") {
                arr[i - 1] = arr[i - 1].toLowerCase();
            }
        }
        return arr.filter((v) => v !== "#").join("");
    }
}

console.log(solution("ABCDEFG", ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]));
console.log(solution("CC#BCC#BCC#BCC#B", ["03:30,04:00,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]));
console.log(solution("A#BC", ["12:00,12:14,HELLO,C#DEFGAB", "14:00,14:05,WOOD,A#BCDEFG", "13:00,13:06,WORLD,A#BCDEF", "13:00,13:06,WORLD,A#BCDEF"]));
console.log(solution("ABC", ["12:00,12:14,HELLO,C#DEFGABA", "14:00,14:05,WOOD,ABDEFG", "13:00,13:05,WORLD,ABDEF"]));
