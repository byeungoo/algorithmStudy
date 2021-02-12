import java.util.*;

class Solution {

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        //1. list에 트리 노드 요소를 위에서부터 정렬해서 넣음
        Node[] nodeList = new Node[nodeinfo.length];

        for(int i=0;i<nodeinfo.length;i++){
            nodeList[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }

        Arrays.sort(nodeList, new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n2.y == n1.y ? n1.x - n2.x : n2.y - n1.y;
            }
        });

        //2. Root Tree에 계속 추가
        Node root = nodeList[0];

        for(int i=1;i<nodeinfo.length;i++){
            Node node = nodeList[i];
            root.addNode(node);
        }

        //3. preorder
        List<Integer> list = new ArrayList<>();

        preOrder(root, list);
        for(int i=0;i<list.size();i++) {
            answer[0][i] = list.get(i);
        }

        list.clear();

        //4. postorder
        postOrder(root, list);
        for(int i=0;i<list.size();i++) {
            answer[1][i] = list.get(i);
        }

        return answer;
    }

    public static void postOrder(Node root, List<Integer> list){
        if(root.leftNode != null)
            postOrder(root.leftNode, list);
        if(root.rightNode != null)
            postOrder(root.rightNode, list);
        list.add(root.getNum());
    }

    public static void preOrder(Node root, List<Integer> list){
        list.add(root.getNum());
        if(root.leftNode != null)
            preOrder(root.leftNode, list);
        if(root.rightNode != null)
            preOrder(root.rightNode, list);
    }

    public class Node{
        private int num;
        public int x;
        public int y;
        private Node leftNode;
        private Node rightNode;

        public Node(int x, int y, int num){
            this.x = x;
            this.y = y;
            this.num = num;
        }

        public int getNum(){
            return num;
        }

        public void addNode(Node node){
            if(x > node.x){
                if(leftNode == null)
                    leftNode = node;
                else
                    leftNode.addNode(node);

            } else if(x < node.x){
                if(rightNode == null)
                    rightNode = node;
                else
                    rightNode.addNode(node);
            }
        }

    }

}