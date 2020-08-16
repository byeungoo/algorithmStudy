function solution(operations) {
  const opLen = operations.length;
  let answer = [];
  for (let i = 0; i < opLen; i++) {
    const [command, value] = operations[i].split(' ');
    switch (command) {
      case 'I':
        answer.push(Number(value));
        answer = answer.sort((a, b) => a - b);
        break;
      case 'D':
        if (answer.length == 0) {
          break;
        }
        if (value === '-1') {
          answer.shift();
        } else {
          answer.pop();
        }
        break;

      default:
        break;
    }
  }

  if (answer.length == 0) {
    return [0, 0];
  } else {
    return [answer[answer.length - 1], answer[0]];
  }
}

console.log(solution(['I 7', 'I 5', 'I -5', 'D -1']));
console.log(solution(['I 7', 'D 1', 'D -1']));
console.log(solution(['I 7', 'D 1', 'D -1', 'I 8']));
console.log(solution(['I -45', 'I 653', 'D 1', 'I -642', 'I 45', 'I 97', 'D 1', 'D -1', 'I 333']));
console.log(solution(['I 4', 'I 3', 'I 2', 'I 1', 'D 1', 'D 1', 'D -1', 'D -1', 'I 5', 'I 6']));
console.log(
  solution([
    'I 1',
    'I 2',
    'I 3',
    'I 4',
    'I 5',
    'I 6',
    'I 7',
    'I 8',
    'I 9',
    'I 10',
    'D 1',
    'D -1',
    'D 1',
    'D -1',
    'I 1',
    'I 2',
    'I 3',
    'I 4',
    'I 5',
    'I 6',
    'I 7',
    'I 8',
    'I 9',
    'I 10',
    'D 1',
    'D -1',
    'D 1',
    'D -1',
  ])
);
