function solution(progresses, speeds) {
  const workLen = progresses.length;
  const answer = [];
  if (workLen == 0) {
    return [0];
  }

  // console.log(progresses, speeds);
  const workingDay = Array(workLen)
    .fill(0)
    .map((v, i) => Math.ceil((100 - progresses[i]) / speeds[i]));

  // console.log(workingDay);

  let max = workingDay[0];
  let cnt = 1;
  for (let i = 1; i < workLen; i++) {
    if (max < workingDay[i]) {
      max = workingDay[i];
      answer.push(cnt);
      cnt = 1;
    } else {
      cnt += 1;
    }

    if (i == workLen - 1) {
      answer.push(cnt);
    }
  }

  return answer;
}

console.log(solution([93, 30, 55], [1, 30, 5]));
