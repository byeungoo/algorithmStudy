const solution = (genres, plays) => {
  let answer = [];
  const bestMap = new Map();
  let len = genres.length;
  for (let i = 0; i < len; i++) {
    if (!bestMap.get(genres[i])) {
      bestMap.set(genres[i], {
        sum: 0,
        plays: [],
      });
    }

    bestMap.get(genres[i]).sum += plays[i];
    bestMap.get(genres[i]).plays.push([i, plays[i]]);
  }

  let test = [...bestMap.entries()]
    .sort((a, b) => {
      return a[1].sum > b[1].sum ? -1 : 1;
    })
    .map((v) => {
      v[1].plays = v[1].plays.sort((a, b) => {
        if (a[1] == b[1]) {
          return a[0] - b[0];
        }
        return b[1] - a[1];
      });

      return v;
    });

  // console.log(test[1][1].plays);

  test.forEach((v) => {
    answer.push(v[1].plays[0][0]);
    v[1].plays.length > 1 && answer.push(v[1].plays[1][0]);
  });

  // console.log(answer);
  return answer;
};
