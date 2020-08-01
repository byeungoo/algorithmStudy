const solution = (citations) => {
  const sorted = citations.sort((a, b) => b - a);
  const len = sorted.length;
  console.log(sorted);

  if (sorted[0] === 0) {
    return 0;
  }

  for (let i = 0; i < len; i++) {
    if (sorted[i] <= i) {
      return i;
    }
  }
  return len;
};

console.log(solution([3, 2, 2, 8, 10, 0, 6, 1, 5]));
console.log(solution([0]));
console.log(solution([3, 0, 6, 1, 5]));
console.log(solution([6, 6, 6, 6]));
