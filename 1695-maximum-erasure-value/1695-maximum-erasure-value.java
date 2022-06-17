class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        Set<Integer> numsSubarray = new HashSet<>();

        while(i < nums.length && j < nums.length){
            if(!numsSubarray.contains(nums[j])){
                sum+=nums[j];
                max = Math.max(max, sum);
                numsSubarray.add(nums[j++]);
            }else{
                sum = sum - nums[i];
                numsSubarray.remove(nums[i++]);
            }
        }
        return max;
    }
}