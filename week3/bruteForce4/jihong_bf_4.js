function solution(n, computers) {
  var answer = 0;
  const netMap = new Map();

  for (let i = 0; i < n; i++) {
    netMap.set(i, []);
    for (let j = 0; j < n; j++) {
      if (i == j) {
        continue;
      }

      if (computers[i][j] == 1) {
        netMap.get(i).push(j);
      }
    }
  }

  console.log(netMap);

  for (let key of netMap.keys()) {
    let index = 0;

    while (index < netMap.get(key).length) {
      const nodes = netMap.get(key);
      const nextNode = nodes[index];
      index += 1;

      if (nextNode === key) {
        continue;
      }

      netMap.set(key, Array.from(new Set([...nodes, ...netMap.get(nextNode)])));
      netMap.delete(nextNode);
    }
  }

  console.log(netMap);
  return netMap.size;
}
console.log(
  solution(5, [
    [1, 1, 0, 1, 0],
    [1, 1, 0, 1, 0],
    [0, 0, 1, 0, 1],
    [1, 1, 0, 1, 0],
    [0, 0, 1, 0, 1],
  ])
);
