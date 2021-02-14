function solution(nodeinfo) {
    var answer = [[]];
    const nodeTree = new Map();
    const sortedNode = nodeinfo
        .map((v, i) => {
            return new Node(v[0], v[1], i + 1);
        })
        .sort((a, b) => {
            if (a.y !== b.y) {
                return b.y - a.y;
            } else {
                return a.x - b.x;
            }
        });

    const rootNode = sortedNode[0];

    sortedNode.forEach((node, i) => {
        if (i !== 0) rootNode.insert(node);
    });

    return [preOrder(rootNode), postOrder(rootNode)];

    function preOrder(node) {
        let temp = [];
        temp.push(node.idx);

        if (node.leftNode) {
            temp = [...temp, ...preOrder(node.leftNode)];
        }

        if (node.rightNode) {
            temp = [...temp, ...preOrder(node.rightNode)];
        }
        return temp;
    }

    function postOrder(node) {
        let temp = [];

        if (node.leftNode) {
            temp = [...temp, ...postOrder(node.leftNode)];
        }

        if (node.rightNode) {
            temp = [...temp, ...postOrder(node.rightNode)];
        }

        temp.push(node.idx);

        return temp;
    }
}

class Node {
    constructor(x, y, idx) {
        this.idx = idx;
        this.x = x;
        this.y = y;
        this.leftNode = null;
        this.rightNode = null;
    }

    insert(node) {
        node.x <= this.x ? this.toLeft(node) : this.toRight(node);
    }

    toLeft(node) {
        this.leftNode ? this.leftNode.insert(node) : (this.leftNode = new Node(node.x, node.y, node.idx));
    }

    toRight(node) {
        this.rightNode ? this.rightNode.insert(node) : (this.rightNode = new Node(node.x, node.y, node.idx));
    }
}

console.log(
    solution([
        [5, 3],
        [11, 5],
        [13, 3],
        [3, 5],
        [6, 1],
        [1, 3],
        [8, 6],
        [7, 2],
        [2, 2],
    ])
);
