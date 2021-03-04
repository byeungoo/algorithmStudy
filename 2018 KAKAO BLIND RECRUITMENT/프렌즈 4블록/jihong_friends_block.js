function solution(m, n, board) {
    var answer = 0;
    const rotatedBoard = rotateMatrix(
        m,
        n,
        board.map((v) => [...v])
    );

    let tempBoard = rotatedBoard;

    while (true) {
        const check = checkBoard(n, m, tempBoard);
        if (check.length > 0) {
            tempBoard = removeCell(n, m, check, tempBoard);
        } else {
            break;
        }
    }

    return countRemovedCell(tempBoard);

    function rotateMatrix(m, n, board) {
        const rotated = Array.from(Array(n), () => Array(m).fill(null));

        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                rotated[j][m - i - 1] = board[i][j];
            }
        }
        return rotated;
    }

    function checkBoard(m, n, board) {
        const checked = Array.from(Array(m), () => Array(n).fill(true));
        let checker = false;

        for (let i = 0; i < m - 1; i++) {
            for (let j = 0; j < n - 1; j++) {
                if (board[i][j] !== "" && board[i][j] === board[i][j + 1] && board[i][j] === board[i + 1][j] && board[i][j] === board[i + 1][j + 1]) {
                    checked[i][j] = false;
                    checked[i + 1][j] = false;
                    checked[i][j + 1] = false;
                    checked[i + 1][j + 1] = false;
                    checker = true;
                }
            }
        }

        return checker ? checked : [];
    }

    function removeCell(m, n, checkdBoard, board) {
        const removedBoard = Array.from(Array(m), () => Array(n).fill(""));

        for (let i = 0; i < m; i++) {
            for (let j = 0; j < n; j++) {
                if (!checkdBoard[i][j]) {
                    removedBoard[i][j] = "REMOVE";
                } else {
                    removedBoard[i][j] = board[i][j];
                }
            }
        }

        return removedBoard.map((row) => {
            const temp = row.filter((v) => v !== "REMOVE");
            return temp.concat(Array(n - temp.length).fill(""));
        });
    }

    function countRemovedCell(board) {
        return board.reduce((prev, cur) => {
            return prev + cur.filter((v) => v == "").length;
        }, 0);
    }
}

console.log(solution(4, 5, ["CCBDE", "AAADE", "AAABF", "CCBBF"]));

console.log(solution(6, 6, ["TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"]));
