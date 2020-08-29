/**
 * 4중 for문... 돌렸습니다.....ㅠㅠㅠ
 */

function solution(N, number) {
  // 8번 돌았을때 답 없으면 -1 반환
  let answer = -1;
  /** 사칙연산 한 값을 저장할 배열 초기화
   * ex) N=5, [0, [5]]
   * 맨 앞에 0을 넣은 이유는 배열 인덱스 값이랑 answer 값이랑 맞추고 싶어서..
   * ex) 배열 2번 인덱스 = 5를 두개 쓴 사칙연산의 결과값
   */

  const arr = [0, [N]];

  // 2번 인덱스부터 시작, 숫자 8개 쓸때까지 반복
  for (let i = 2; i <= 8; i++) {
    // 사칙연산 계산 값 중 중복값 제거해야 하니까 Set 선언
    const tempSet = new Set();

    // 55, 555 같은 값을 미리 배열에 추가
    tempSet.add(Number(String(N).repeat(i)));

    /**
     * 현재 인덱스의 절반 까지만 반복문을 돕니다.
     * 예를 들어 5를 5개 사용 하는 경우를 계산 하려면
     * (5를 1개 쓴 결과값, 5를 4개 쓴 결과값), (5를 3개 쓴 결과값, 5를 2개 쓴 결과값)
     * 만 고려하면 되기 때문
     */
    for (let j = 1; j <= i / 2; j++) {
      /**
       * ex) (5를 1개 쓴 결과값, 5를 4개 쓴 결과값)에 각각 접근해서 사칙연산을 수행
       */
      for (let k = 0; k < arr[i - j].length; k++) {
        for (let l = 0; l < arr[j].length; l++) {
          tempSet.add(arr[i - j][k] + arr[j][l]);
          tempSet.add(arr[i - j][k] - arr[j][l]);
          tempSet.add(arr[i - j][k] * arr[j][l]);
          arr[j][l] !== 0 && tempSet.add(Math.floor(arr[i - j][k] / arr[j][l]));
          // -, / 는 교환법칙이 성립 안하니까 순서를 바꿔서 빼고, 나눠줍니다.. 한참헤맸네..
          tempSet.add(arr[j][l] - arr[i - j][k]);
          arr[i - j][k] !== 0 && tempSet.add(Math.floor(arr[j][l] / arr[i - j][k]));
        }
      }
    }

    // Set을 배열로 바꿔서 사칙연산 결과값 배열에 추가
    arr.push([...tempSet]);

    // 결과값이 현재 set에 있으면 현재 i 값을 그대로 반환하고 반복문 종료
    if (tempSet.has(number)) {
      answer = i;
      break;
    }
  }

  // console.log(arr);
  return answer;
}

console.log(solution(5, 12));
