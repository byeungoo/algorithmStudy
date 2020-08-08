function solution(tickets) {
  const ticketsMap = new Map();
  const ticketsLen = tickets.length;
  const answer = [];

  // ticket 그래프
  for (let i = 0; i < ticketsLen; i++) {
    const start = tickets[i][0];
    const end = tickets[i][1];

    if (!ticketsMap.get(start)) {
      ticketsMap.set(start, [end]);
    } else {
      ticketsMap.get(start).push(end);
    }
  }

  for (let tickets of ticketsMap.values()) {
    tickets.sort();
  }

  answer.push('ICN');
  findRoute('ICN', 0);

  return answer;

  function findRoute(cur, index) {
    if (!ticketsMap.get(cur) || ticketsMap.get(cur).length == 0) {
      return answer.length == ticketsLen + 1 ? true : false;
    }
    const mapLen = ticketsMap.get(cur).length;
    for (let i = 0; i < mapLen; i++) {
      const next = ticketsMap.get(cur)[i];
      answer.push(next);
      ticketsMap.get(cur).splice(i, 1);
      const res = findRoute(next);
      if (res) {
        return true;
      } else {
        answer.pop();
        ticketsMap.get(cur).splice(i, 0, next);
      }
    }

    return false;
  }
}

console.log(
  solution([
    ['ICN', 'JFK'],
    ['HND', 'IAD'],
    ['JFK', 'HND'],
  ])
);
console.log(
  solution([
    ['ICN', 'SFO'],
    ['ICN', 'ATL'],
    ['SFO', 'ATL'],
    ['ATL', 'ICN'],
    ['ATL', 'SFO'],
  ])
);

console.log(
  solution([
    ['ICN', 'A'],
    ['ICN', 'A'],
    ['A', 'ICN'],
  ])
);

console.log(
  solution([
    ['ICN', 'COO'],
    ['ICN', 'BOO'],
    ['COO', 'ICN'],
    ['BOO', 'DOO'],
  ])
);
