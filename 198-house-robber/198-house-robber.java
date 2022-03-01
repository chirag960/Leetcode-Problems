class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        memo.put(0,nums[0]);
        
        memo.put(1,Math.max(nums[0],nums[1]));
        int ans = dp(nums.length-1, nums,memo);
        return ans;
        
    }
    
    public static int dp(int i, int[] nums, HashMap<Integer, Integer> memo){
        if(i<2){
            return memo.get(i);
        }
        if(!memo.containsKey(i)){
            memo.put(i, Math.max(dp(i-1,nums,memo),dp(i-2,nums,memo)+nums[i]));    
        }
        
        return memo.get(i);
    }
    
}