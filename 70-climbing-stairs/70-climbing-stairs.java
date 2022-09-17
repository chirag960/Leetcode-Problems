class Solution {
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        
        int[] dp = new int[n];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        dp[0] = 1;
        dp[1] = 2;
        recur(n-1, dp);
        return dp[n-1];
    }
    
    public int recur(int n, int[] dp){
        if(dp[n] == -1){
            dp[n] = recur(n-1, dp) + recur(n-2, dp);
        }
        return dp[n];
        
    }
}