function solution(begin, target, words) {
  var answer = 987654321;
  const wordsLen = words.length;
  const wordsMap = new Map(words.map((v) => [v, []]));
  const visited = new Map(words.map((v) => [v, false]));

  for (let i = 0; i < wordsLen; i++) {
    const curWord = words[i];
    for (let j = 0; j < wordsLen; j++) {
      const target = words[j];
      if (i !== j && matchWords(curWord, target)) {
        wordsMap.get(curWord).push(target);
      }
    }
  }
  wordsMap.set(begin, []);
  for (let i = 0; i < wordsLen; i++) {
    if (matchWords(begin, words[i])) {
      wordsMap.get(begin).push(words[i]);
    }
  }
  console.log(wordsMap);
  searchRoute(begin, target, 0);
  return answer == 987654321 ? 0 : answer;

  function searchRoute(word, target, depth) {
    // 방문 했을 때
    if (visited.get(word)) {
      return;
    }

    //같을 때
    if (word === target) {
      answer > depth ? (answer = depth) : answer;
      return;
    }

    console.log(word);
    const currentWordList = wordsMap.get(word);
    console.log(currentWordList);
    const listLen = currentWordList.length;
    visited.set(word, true);
    console.log(visited);

    for (let i = 0; i < listLen; i++) {
      const nextWord = currentWordList[i];
      if (!visited.get(nextWord)) {
        searchRoute(nextWord, target, depth + 1);
      }
    }

    visited.set(word, false);

    return;
  }

  function matchWords(cur, target) {
    const len = cur.length;
    let wordCheck = 0;

    for (let i = 0; i < len; i++) {
      if (cur[i] !== target[i]) {
        wordCheck += 1;
      }
    }

    return wordCheck === 1;
  }
}

console.log(solution('hit', 'cog', ['hot', 'dot', 'dog', 'lot', 'log', 'cog']));
console.log(solution('hit', 'cog', ['hot', 'dot', 'dog', 'lot', 'log']));
