function solution(p) {
    return transform(p);

    function transform(w) {
        if (w === "") {
            return w;
        }
        // console.log("w", w);
        const [u, v] = splitEqual(w);
        // console.log("u", u, "v", v);

        if (check(u)) {
            return u + transform(v);
        } else {
            const tmp = "(" + transform(v) + ")";
            const reverse = [...u.slice(1, u.length - 1)]
                .map((v) => (v === "(" ? ")" : "("))
                .join("");
            // console.log("tmp", tmp); [1,2,3] => '1,2,3'
            // console.log("reverse", reverse);
            return tmp + reverse;
        }
    }

    // 올바른 괄호 문자열 체크
    function check(s) {
        const mStack = [];

        if (s.length === 1 || s.charAt(0) === ")") {
            return false;
        }

        mStack.push(s.charAt(0));
        for (let i = 1; i < s.length; i++) {
            const curStr = s.charAt(i);

            if (curStr === "(") {
                mStack.push(s.charAt(i));
            } else {
                if (mStack.length > 0) {
                    mStack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    // 균형잡힌 괄호 문자열 분리
    function splitEqual(s) {
        let right = 0;
        let left = 0;
        let index = 0;

        for (let i = 0; i < s.length; i++) {
            if (s.charAt(i) === "(") {
                right += 1;
            } else {
                left += 1;
            }

            if (right === left && right != 0 && left != 0) {
                index = i;
                break;
            }
        }

        return [s.slice(0, index + 1), s.slice(index + 1)];
    }
}

console.log(solution("(()())()"));
console.log(solution(")("));
console.log(solution("()))((()"));
