class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        
        dp[dp.length-1] = nums[nums.length-1];
        dp[dp.length-2] = Math.max(nums[nums.length-2],nums[nums.length-1]);
        cache(nums, 0, dp);
        return Math.max(dp[0], dp[1]);
        
    }
    
    public int cache(int nums[], int n, int[] dp){
        if(dp[n] == -1){
            dp[n] = Math.max(nums[n] + cache(nums, n+2, dp), cache(nums, n+1, dp));
        }
        return dp[n];
    }
    
}