function solution(files) {
    const regex = /(\d{1,5})/g;
    const sortedFiles = files
        .map((v, i) => {
            const [head, number, tail] = v.split(regex);
            const compHead = head.toLowerCase();
            const compNumber = Number(number);
            console.log(compHead, compNumber, tail);

            return {
                orginData: v,
                compHead: compHead,
                compNumber: compNumber,
                index: i,
            };
        })
        .sort((a, b) => {
            if (a.compHead === b.compHead) {
                if (a.compNumber === b.compNumber) {
                    return a.index - b.index;
                }
                return a.compNumber - b.compNumber;
            }

            return a.compHead < b.compHead ? -1 : a.compHead > b.compHead ? 1 : 0;
        })
        .map((v) => {
            return v.orginData;
        });

    // console.log(sortedFiles);
    return sortedFiles;
}

const regex = /(\d+)/g;
console.log("foo010bar020.zip".split(regex));
console.log("A-10 Thunderbolt II".split(regex));

console.log(solution(["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG", "f-15"]));
console.log(solution(["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]));
