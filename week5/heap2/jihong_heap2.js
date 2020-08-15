function solution(jobs) {
  let seconds = 0;
  let jobsCnt = 0;
  let secondsSum = 0;
  const jobsLen = jobs.length;

  // console.log(jobsLen);
  while (jobsCnt < jobsLen) {
    const temp = jobs.filter((v) => v[0] <= seconds).sort((a, b) => a[1] - b[1]);
    // console.log('seconds', seconds);
    // console.log('temp', temp);
    if (temp.length > 0) {
      secondsSum += seconds + temp[0][1] - temp[0][0];
      // console.log('sum', seconds + temp[0][1] - temp[0][0]);
      seconds += temp[0][1];
      jobsCnt += 1;
      jobs.splice(
        jobs.findIndex((v) => v == temp[0]),
        1
      );
      // console.log('jobs', jobs);
      // console.log('len', jobsCnt + '\n');
    } else {
      seconds += 1;
    }
  }

  return Math.floor(secondsSum / jobsLen);
}

console.log(
  solution([
    [0, 3],
    [1, 9],
    [2, 6],
  ])
);
