const solution = (numbers) => {
  const numSet = new Set();
  const len = numbers.length;
  for (let i = 0; i < len; i++) {
    permute(numbers, i + 1)
      .map((v) => Number(v))
      .forEach((v) => numSet.add(v));
  }

  return Array.from(numSet).reduce((acc, cur) => {
    return isPrime(cur) ? acc + 1 : acc;
  }, 0);
};

const isPrime = (number) => {
  if (number === 0 || number === 1) {
    return false;
  }
  for (let i = 2; i * i < number + 1; i++) {
    if (number % i === 0) {
      return false;
    }
  }
  return true;
};

const permute = (input, num) => {
  const len = input.length;
  const tmpArr = [...input];
  let result = [];
  if (num == 1) {
    return tmpArr;
  }

  for (let i = 0; i < len; i++) {
    const fixed = tmpArr.splice(i, 1)[0];
    const permuted = permute(tmpArr, num - 1);
    const att = permuted.map((v) => [fixed, ...v]);
    tmpArr.splice(i, 0, fixed);
    result.push(...att);
  }

  return Array.from(new Set(result.map((v) => v.join(''))));
};

console.log(solution('011'));
