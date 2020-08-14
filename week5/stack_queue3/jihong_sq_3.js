function solution(bridge_length, weight, truck_weights) {
  let index = 1;
  let weightSum = truck_weights[0];
  let seconds = 0;
  let bridge_queue = [[truck_weights[0], seconds + bridge_length]];

  while (bridge_queue.length > 0 || index < truck_weights.length) {
    if (bridge_queue.length > 0 && bridge_queue[0][1] <= seconds) {
      weightSum = weightSum - bridge_queue[0][0] < 0 ? 0 : weightSum - bridge_queue[0][0];
      bridge_queue.shift();
    }

    if (weightSum + truck_weights[index] <= weight) {
      weightSum += truck_weights[index];
      bridge_queue.push([truck_weights[index], seconds + bridge_length]);
      index += 1;
    }
    // console.log(seconds);
    // console.log(bridge_queue);

    seconds += 1;
  }
  return seconds;
}

console.log(solution(2, 10, [7, 4, 5, 6]));
console.log(solution(100, 100, [10]));
console.log(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]));
