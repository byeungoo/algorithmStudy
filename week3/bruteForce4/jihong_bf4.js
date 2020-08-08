function solution(brown, yellow) {
  let bWidth = brown / 2 - 1;
  let bHeight = 3;
  const answer = [];
  while (bWidth >= bHeight) {
    if (yellow == (bHeight - 2) * (bWidth - 2)) {
      // console.log(bWidth, bHeight);
      answer.push(bWidth);
      answer.push(bHeight);
    }

    bWidth -= 1;
    bHeight += 1;
  }

  return answer;
}

console.log(solution(10, 2));
