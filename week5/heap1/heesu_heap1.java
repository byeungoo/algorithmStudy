import java.util.ArrayList;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        boolean isPossible = false;
        MinHeap mh = new MinHeap();

        for(int i=0;i<scoville.length;i++){
            mh.insert(scoville[i]);
        }
        while(true){

            int v1 = mh.delete();
            int v2 = mh.delete();
            if(v1 == -1 || v2 ==-1) break;

            mh.insert(v1 + 2*v2);

            //처리 후, 가장 작은값 >= K
            if(mh.heap.get(1) >= K){
                isPossible = true;
                break;
            }else{
                answer++;
            }
        }
        return isPossible ? answer+1 : -1;
    }
}

class MinHeap{
    ArrayList<Integer> heap;

    MinHeap(){
        heap = new ArrayList<>();
        heap.add(0); // idx 0은 사용안함
    }

    void insert(int val){
        heap.add(val);
        int p = heap.size() - 1;

        //p가 힙구조의 가장 root 노드로 갈때까지 크기비교
        while(p > 1 && heap.get(p/2) > heap.get(p)){
            //부모보다 자식이 작으면 swap (minHeap)
            int tmp = heap.get(p/2);
            heap.set(p/2,heap.get(p));
            heap.set(p, tmp);

            p = p/2; // 기존 부모노드 위치로 변경
        }
    }
    int delete(){
        if(heap.size()-1 < 1){
            //기본 0인덱스를 넣어놓고 힙을 구성하기 때문에 해당 조건을 만족하면 힙이 비어있는 상태
            return -1;
        }

        //root node 삭제
        int deleteItem = heap.get(1);

        //root에 힙의 가장 마지막 요소 insert
        heap.set(1,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        //트리 순서 정리
        int p = 1;
        while(p*2 < heap.size()){
            // 위 조건 만족 -> 자식 node가 존재할때까지 트리 순서 정리

            int min = heap.get(p*2);
            int minp = p*2;

            if( (p*2 +1) < heap.size() && min > heap.get(p*2 +1)){
                // 우측 자식 node가 있는 경우는 해당 node를 min으로 본다.
                min = heap.get(p*2 +1);
                minp = p*2 +1;
            }

            if(heap.get(p) < min){
                //현재자리가 맞다면 더 이상 트리 순서 정리가 필요없다.
                break;
            }

            // 위의 조건이 맞지 않다면 부모 자식 스왑
            int tmp = heap.get(p);
            heap.set(p,heap.get(minp));
            heap.set(minp, tmp);
            p = minp;
        }
        return deleteItem;
    }
}