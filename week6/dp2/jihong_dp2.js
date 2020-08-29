function solution(triangle) {
  for (let i = 1; i < triangle.length; i++) {
    for (let j = 0; j < triangle[i].length; j++) {
      if (j === 0) {
        triangle[i][j] += triangle[i - 1][j];
      } else if (j === i) {
        triangle[i][j] += triangle[i - 1][j - 1];
      } else {
        triangle[i][j] +=
          triangle[i - 1][j] > triangle[i - 1][j - 1] ? triangle[i - 1][j] : triangle[i - 1][j - 1];
      }
    }
  }

  return triangle[triangle.length - 1].reduce((max, cur) => {
    return cur > max ? cur : max;
  });
}

console.log(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]));
// 0 0 7
// 1 0 3
// 1 1 8
// 2 0 8
// 2 1 1
// 2 2 0

//   7
//  10 15
// 18 (11, 16) 15
// 20 (25, 16)  4 4
