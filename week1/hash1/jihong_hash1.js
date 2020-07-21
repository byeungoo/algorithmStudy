function solution(participant, completion) {
  let mdict = participant.reduce((acc, cur, index) => {
    if (!acc[cur]) {
      acc[cur] = 1;
    } else {
      acc[cur] += 1;
    }
    return acc;
  }, {});

  completion.forEach((name) => {
    if (mdict[name] !== 0) {
      mdict[name] -= 1;
    }
  });

  let answer;
  for (let name in mdict) {
    if (mdict[name] !== 0) {
      answer = name;
      break;
    }
  }

  return answer;
}
