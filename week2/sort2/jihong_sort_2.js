const solution = (numbers) => {
  return numbers
    .sort((a, b) => {
      return String(b) + String(a) - (String(a) + String(b));
    })
    .reduce((acc, cur, index, array) => {
      if (index === 0 && cur === 0) {
        array.splice(1);
        return String(cur);
      }
      return String(acc) + String(cur);
    }, '');
};

solution([3, 30, 34, 5, 9]);

solution([0, 0, 0, 0, 0]);
