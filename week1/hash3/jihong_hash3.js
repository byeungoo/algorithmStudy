const solution = (clothes) => {
  var answer = 0;
  let clothesObj = clothes.reduce((acc, cur) => {
    let cloth = cur[0];
    let piece = cur[1];

    if (!acc[piece]) {
      acc[piece] = 0;
    }
    acc[piece] += 1;

    return acc;
  }, {});

  answer = Object.keys(clothesObj).reduce((acc, cur) => {
    return acc * (clothesObj[cur] + 1);
  }, 1);

  // console.log(clothesObj);
  // console.log(answer - 1);

  return answer - 1;
};
