function solution(expression) {
    var answer = -1;

    const nums = expression
        .split(/[^\d]/)
        .filter((v) => v != "")
        .map((v) => parseInt(v));
    const ops = expression.split(/\d/).filter((v) => v != "");
    const opSet = [...new Set(ops)];
    const permutedOp = permutation(opSet, opSet.length);
    console.log(nums);
    console.log(permutedOp);

    permutedOp.forEach((priorArr) => {
        let tmpNums = [...nums];
        let tmpOps = [...ops];

        priorArr.forEach((priorOp) => {
            const numStk = [tmpNums[0]];
            const opStk = [];

            tmpOps.forEach((op, i) => {
                numStk.push(tmpNums[i + 1]);
                opStk.push(op);
                if (priorOp === op) {
                    const result = operator(op, numStk.pop(), numStk.pop());
                    opStk.pop();
                    numStk.push(result);
                }
            });

            tmpNums = numStk;
            tmpOps = opStk;
        });

        answer = answer > Math.abs(tmpNums[0]) ? answer : Math.abs(tmpNums[0]);
    });

    return answer;

    function permutation(array, r) {
        let result = [];
        if (r === 1) {
            return array.map((v) => [v]);
        }

        array.forEach((v, index, arr) => {
            const fixed = v;
            const restArr = arr.filter((_, i) => i !== index);
            const permArr = permutation(restArr, r - 1);
            const combinedArr = permArr.map((v) => [fixed, ...v]);
            result.push(...combinedArr);
        });

        return result;
    }

    function operator(op, a, b) {
        switch (op) {
            case "+":
                return a + b;
            case "*":
                return a * b;
            case "-":
                return b - a;
            default:
                return 0;
        }
    }
}

console.log(solution("100-200*300-500+20"));
