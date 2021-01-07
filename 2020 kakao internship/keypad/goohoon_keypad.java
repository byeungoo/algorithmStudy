class Solution {
    
    class Location{

        int arr[][] = {{1,2,3}, {4,5,6}, {7,8,9}, {-1, 0 ,-2}};
        int l = -1;
        int r = -2;

        public int getRow(int num){
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(arr[i][j]==num)
                        return  i;
                }
            }
            return -1;
        }

        public int getCol(int num){
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(arr[i][j]==num)
                        return  j;
                }
            }
            return -1;
        }

        public int getDistance(int num, String hand){
            int row = getRow(num);
            int col = getCol(num);
            int hRow = 0;
            int hCol = 0;

            if("right".equals(hand)){
                hRow = getRow(r);
                hCol = getCol(r);
            } else if("left".equals(hand)){
                hRow = getRow(l);
                hCol = getCol(l);
            }

            int distance = Math.abs(row-hRow) + Math.abs(col-hCol);
            return distance;
        }

        public void setLocation(int num, String hand){
            if("right".equals(hand)){
                r = num;
            } else if("left".equals(hand)){
                l = num;
            }
        }

    }

    public String solution(int[] numbers, String hand) {
        Location location = new Location();
        String answer = "";

        for(int i=0;i<numbers.length;i++){
            int num = numbers[i]%3;

            if(numbers[i] !=0 && num == 0){
                answer += "R";
                location.setLocation(numbers[i], "right");
            } else if(num == 1){
                answer += "L";
                location.setLocation(numbers[i], "left");
            } else if(num == 2 || numbers[i] == 0){
                int leftDistance = location.getDistance(numbers[i], "left");
                int rightDistance = location.getDistance(numbers[i], "right");

                if(leftDistance < rightDistance) {
                    answer += "L";
                    location.setLocation(numbers[i], "left");
                }
                else if(leftDistance > rightDistance) {
                    answer += "R";
                    location.setLocation(numbers[i], "right");
                }
                else if(leftDistance == rightDistance && "right".equals(hand)) {
                    answer += "R";
                    location.setLocation(numbers[i], "right");
                }
                else if(leftDistance == rightDistance && "left".equals(hand)) {
                    answer += "L";
                    location.setLocation(numbers[i], "left");
                }
            }
        }

        return answer;
    }
}