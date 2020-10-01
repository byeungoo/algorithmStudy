function solution(n, lost, reserve) {
  var answer = 0;
  const student = new Array(n).fill(1);

  lost.forEach((l) => {
    student[l - 1] = 0;
  });
  reserve.forEach((r) => {
    student[r - 1] += 1;
  });

  for (let i = 0; i < student.length; i++) {
    if (student[i] === 0) {
      if (i > 0) {
        if (student[i - 1] > 1) {
          student[i - 1] -= 1;
          student[i] = 1;
          continue;
        }
      }

      if (i < student.length - 1) {
        if (student[i + 1] > 1) {
          student[i + 1] -= 1;
          student[i] = 1;
          continue;
        }
      }
    }
  }
  //   console.log(student);

  return student.filter((v) => v !== 0).length;
}

console.log(solution(5, [2, 4], [1, 3, 5]));
console.log(solution(5, [2, 4], [3]));
console.log(solution(3, [3], [1]));
