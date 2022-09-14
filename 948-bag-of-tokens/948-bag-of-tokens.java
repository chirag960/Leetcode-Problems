class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if(tokens.length == 0){
            return 0;
        }
        
        Arrays.sort(tokens);
        if(power < tokens[0]){
            return 0;
        }
        int left = 0;
        int right = tokens.length-1;
        int score = 0;
        int max = 0;
        int leftsum = 0;
        int rightsum = power;
        while(left <= right){
            if(leftsum+tokens[left] <= rightsum){
                leftsum+=tokens[left];
                left++;
                score++;
                max = Math.max(score, max);
            }else{
                rightsum+=tokens[right];
                right--;
                score--;
            }
        }
        return max;
    }
}