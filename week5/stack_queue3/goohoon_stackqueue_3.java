import java.util.*;

class Solution {
    
    Queue<Truck> departQueue = new LinkedList();
    Queue<Truck> curBridge = new LinkedList();
    Queue<Truck> passTruck = new LinkedList();
    int time = 0;
    
    class Truck{
        public int weight;
        public int location;
        
        Truck(int weight, int location){
            this.weight = weight;
            this.location = location;
        }
        
        void move(){
            this.location += 1;
        }
    }
    
    public void initQueue(int[] truck_weights){
        int len = truck_weights.length;
        for(int i=0;i<len;i++){
            Truck truck = new Truck(truck_weights[i], 0);
            departQueue.offer(truck);
        }
    }
    
    //현재 다리위의 트럭 무게를 구함
    public int totalCurTruckWeight(){
        int totalCurTruckWeight = 0;
        int size = curBridge.size();
        for(int i=0;i<size;i++){
            Truck truck =  curBridge.poll();
            totalCurTruckWeight += truck.weight;
            curBridge.offer(truck);
        }
        return totalCurTruckWeight;
    }
    
    //1초 후 트럭들이 다리를 지나게함
    public void passBridge(int bridge_length, int weight, boolean pushFlag){
        int size = curBridge.size();
        time++;
        
        for(int i=0;i<size;i++){
            Truck truck =  curBridge.poll();
            truck.move();
            if(truck.location <= bridge_length){
                curBridge.offer(truck);
            } else{
                passTruck.offer(truck);
                pushWhenPollLastTruck(weight, pushFlag);
            }
        }
    }
    
    //대기 트럭이 있고, 시작할때 진입한 트럭이 없고, 무게가 가능하다면 트럭이 1대 빠질때 다리에 들어감
    public void pushWhenPollLastTruck(int weight, boolean pushFlag){
        Truck frontTruck = departQueue.peek();
        if(frontTruck != null && pushFlag == false){
            int curTruckTotalWeight = totalCurTruckWeight() + frontTruck.weight;
            if(curTruckTotalWeight <= weight){
                Truck newTruck = departQueue.poll();
                newTruck.location = 1;
                curBridge.offer(newTruck);
            }
        }
    }
    
    public void calulationPassTime(int bridge_length, int weight, int[] truck_weights){
        int curTruckTotalWeight = 0;
        int totalSize = truck_weights.length;
        
        while(passTruck.size() != totalSize){
            Truck truck = departQueue.peek();
            if(truck != null){
                curTruckTotalWeight = totalCurTruckWeight() + truck.weight;
                if(curTruckTotalWeight <= weight && curBridge.size()+1 <= bridge_length){
                    curBridge.offer(departQueue.poll());
                    passBridge(bridge_length, weight, true);
                } else{
                    passBridge(bridge_length, weight, false);
                }
            } else {    
                passBridge(bridge_length, weight, false);
            }
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights){
        initQueue(truck_weights);
        calulationPassTime(bridge_length, weight, truck_weights);
        return time;
    }
}