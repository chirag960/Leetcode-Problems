class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        int[][] joined = new int[length][2];
        for(int i=0;i<length;i++){
            joined[i][0] = position[i];
            joined[i][1] = speed[i];
        }

        Arrays.sort(joined, Comparator.comparingInt(a->a[0]));


        double frontCarTime = (double)(target - joined[length-1][0])/joined[length-1][1];
        int result = 1;
        for(int i=length-2;i>=0;i--){
            double currentCarTime = (double)(target - joined[i][0])/joined[i][1];
            if(currentCarTime > frontCarTime){
                result++;
                frontCarTime = currentCarTime;
            }
        }
        return result;
    }
}