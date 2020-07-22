const solution = (array, commands) => {
  return commands.map(
    ([start, end, index]) => array.slice(start - 1, end).sort((a, b) => a - b)[index - 1]
  );
};

console.log(
  solution(
    [100, 52, 24, 65, 32, 71, 45, 10],
    [
      [2, 5, 3],
      [4, 4, 1],
      [1, 7, 3],
    ]
  )
);

// 개빡치는 자바스크립트
console.log([100, 52, 24, 65, 32, 71, 45, 10].sort());
