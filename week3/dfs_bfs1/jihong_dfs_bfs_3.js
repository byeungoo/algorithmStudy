function solution(numbers, target) {
  let answer = 0;

  const len = numbers.length;
  let queue = [0];
  let index = 0;

  while (queue.length !== 0 && index < len) {
    let tempQueue = [];
    const qlen = queue.length;

    for (let i = 0; i < qlen; i++) {
      const curValue = queue[i];
      // console.log('inqu', queue);
      const nextValue1 = curValue + numbers[index];
      const nextValue2 = curValue - numbers[index];
      tempQueue.push(nextValue1);
      tempQueue.push(nextValue2);

      if (index == len - 1 && nextValue1 == target) {
        answer += 1;
      }
      if (index == len - 1 && nextValue2 == target) {
        answer += 1;
      }
    }

    // console.log('temp', tempQueue);
    queue = tempQueue;
    index += 1;

    // console.log('queue', queue);
  }

  return answer;
}

console.log(solution([2, 2, 2, 2, 2, 1], 7));
