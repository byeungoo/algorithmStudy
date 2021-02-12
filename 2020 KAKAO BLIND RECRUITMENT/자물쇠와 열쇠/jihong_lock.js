function solution(key, lock) {
    const keyLen = key.length;
    const lockLen = lock.length;
    const solArrayLen = 2 * keyLen + lockLen - 2;
    const solArray = Array(solArrayLen)
        .fill(null)
        .map((v) => Array(solArrayLen).fill(-9));

    // init
    for (let i = 0; i < lockLen; i++) {
        for (let j = 0; j < lockLen; j++) {
            solArray[i + keyLen - 1][j + keyLen - 1] = lock[i][j];
        }
    }

    // console.log(solArray);
    // console.log(solArray.filter((_, i) => i >= keyLen - 1 && i < keyLen + lockLen - 1).map((v) => v.slice(keyLen - 1, keyLen + lockLen - 1)));

    let keyCopy = key.map((v) => [...v]);

    for (let r = 0; r < 4; r++) {
        for (let i = 0; i < solArrayLen - keyLen; i++) {
            for (let j = 0; j < solArrayLen - keyLen; j++) {
                if (checkUnlock(solArray, keyCopy, i, j, lockLen)) {
                    return true;
                }
            }
        }
        keyCopy = rotate(keyCopy);
    }

    return false;

    function rotate(key) {
        const keyLength = key.length;
        const rotatedKey = Array(keyLength)
            .fill(null)
            .map((v) => Array(keyLength).fill(0));

        for (let i = 0; i < keyLength; i++) {
            for (let j = 0; j < keyLength; j++) {
                rotatedKey[i][j] = key[keyLength - j - 1][i];
            }
        }

        return rotatedKey;
    }

    function isUnlock(key) {
        const keyLen = key.length;

        for (let i = 0; i < keyLen; i++) {
            for (let j = 0; j < keyLen; j++) {
                if (key[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    function checkUnlock(solArr, key, keyRow, keyCol, lockLen) {
        // console.log("check");
        const keyLen = key.length;
        const sol = solArr.map((v) => [...v]);

        for (let i = 0; i < keyLen; i++) {
            for (let j = 0; j < keyLen; j++) {
                sol[i + keyRow][j + keyCol] += key[i][j];
                // console.log(i + keyRow, keyCol + j, sol[i + keyRow][j + keyCol]);
            }
        }

        // console.log(sol.filter((_, i) => i >= keyLen - 1 && i < keyLen + lockLen - 1).map((v) => v.slice(keyLen - 1, keyLen + lockLen - 1)));

        return isUnlock(sol.filter((_, i) => i >= keyLen - 1 && i < keyLen + lockLen - 1).map((v) => v.slice(keyLen - 1, keyLen + lockLen - 1)));
    }
}

console.log(
    solution(
        [
            [0, 0, 0],
            [1, 0, 0],
            [0, 1, 1],
        ],
        [
            [1, 1, 1, 1],
            [1, 1, 0, 1],
            [1, 0, 1, 1],
            [1, 0, 1, 1],
        ]
    )
);
