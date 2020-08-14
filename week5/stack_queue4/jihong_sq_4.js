function solution(priorities, location) {
  let new_prior = priorities.map((v, i) => {
    return [v, i];
  });
  let count = 1;

  while (true) {
    const maxIndex = findMaxIndex(new_prior);
    const max = new_prior[maxIndex];
    if (max[1] == location) {
      return count;
    }
    new_prior = new_prior.slice(maxIndex + 1).concat(new_prior.slice(0, maxIndex));
    count += 1;
  }

  return 0;

  function findMaxIndex(arr) {
    let index = 0;
    let max = -1;
    for (let i = 0; i < arr.length; i++) {
      if (max < arr[i][0]) {
        max = arr[i][0];
        index = i;
      }
    }

    return index;
  }
}

console.log(solution([2, 1, 3, 2], 2));
console.log(solution([1, 1, 9, 1, 1, 1], 0));
