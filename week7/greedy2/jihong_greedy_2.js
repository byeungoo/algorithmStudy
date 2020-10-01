function solution(number, k) {
  const len = number.length - k;
  return [...number]
    .reduce(
      (prev, cur) => {
        while (k > -1 && prev[prev.length - 1] < cur) {
          prev.pop();
          k -= 1;
        }
        prev.push(cur);
        return prev;
      },
      [0]
    )
    .join("")
    .substring(0, len);
}

console.log(solution("4177252841", 4));
console.log(solution("1924", 2));
console.log(solution("999999999", 6));
console.log(solution("1111", 2));
