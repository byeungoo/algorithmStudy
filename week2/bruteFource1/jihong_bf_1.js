const solution = (answers) => {
  const pattern = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ];
  const len = answers.length;
  let correct = [0, 0, 0];

  for (let i = 0; i < len; i++) {
    if (answers[i] === pattern[0][i % 5]) {
      correct[0] += 1;
    }

    if (answers[i] === pattern[1][i % 8]) {
      correct[1] += 1;
    }

    if (answers[i] === pattern[2][i % 10]) {
      correct[2] += 1;
    }
  }

  const max = Math.max(...correct);

  const answer = correct
    .map((value, index) => {
      return value == max ? index + 1 : -1;
    })
    .filter((v) => v != -1)
    .sort((a, b) => a - b);

  return answer;
};

console.log(solution([1, 2, 3, 4, 5]));
