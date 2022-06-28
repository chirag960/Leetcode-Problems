class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> differenceMap= new HashMap<>();

        for(int i=0;i<nums.length;i++){
             if(!differenceMap.containsKey(nums[i])){
                differenceMap.put(target-nums[i], i);
             }
             else{
                 return new int[]{differenceMap.get(nums[i]),i};
             }
        }
        return new int[] {};
    }
}