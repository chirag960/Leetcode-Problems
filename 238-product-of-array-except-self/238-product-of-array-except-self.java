class Solution {
        public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        int product = 1;
        for(int i=1;i<prefix.length;i++){
            product*=nums[i-1];
            prefix[i] = product;
        }

        product = 1;
        for(int i=prefix.length-1;i>0;i--){
            product*=nums[i];
            prefix[i-1] *= product;
        }

        return prefix;
        }
}