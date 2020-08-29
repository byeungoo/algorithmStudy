/**
 * 4중 for문... 돌렸습니다.....ㅠㅠㅠ
 */

function solution(N, number) {
  let answer = -1;
  const arr = [0, [N]];

  for (let i = 2; i <= 8; i++) {
    const tempSet = new Set();
    tempSet.add(Number(String(N).repeat(i)));
    for (let j = 1; j <= i / 2; j++) {
      for (let k = 0; k < arr[i - j].length; k++) {
        for (let l = 0; l < arr[j].length; l++) {
          tempSet.add(arr[i - j][k] + arr[j][l]);
          tempSet.add(arr[i - j][k] - arr[j][l]);
          tempSet.add(arr[j][l] - arr[i - j][k]);
          tempSet.add(arr[i - j][k] * arr[j][l]);
          arr[j][l] !== 0 && tempSet.add(Math.floor(arr[i - j][k] / arr[j][l]));
          arr[i - j][k] !== 0 && tempSet.add(Math.floor(arr[j][l] / arr[i - j][k]));
        }
      }
    }
    arr.push([...tempSet]);
    if (tempSet.has(number)) {
      answer = i;
      break;
    }
  }

  // console.log(arr);
  return answer;
}

console.log(solution(5, 12));
