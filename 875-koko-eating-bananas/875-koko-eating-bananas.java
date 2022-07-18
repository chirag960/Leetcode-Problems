class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int end = piles[0];
        for(int i : piles){
            end = Math.max(i, end);
        }
        
        int start = 1;
        int mid = 0;
        while(start<end){
            mid = (start+end)/2;
            int speed = 0;
            for(int i : piles){
                speed += Math.ceil((double)i/mid);
            }
            if(speed > h){
                start = mid+1;
            }
            else{
                end = mid;
            }
            
        }
        return end;
        
    }
}