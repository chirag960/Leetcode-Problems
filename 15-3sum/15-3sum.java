class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int j=i+1, k=nums.length-1;
            while(j < k){
                if(nums[j] + nums[k] == target){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    result.add(list);
                    while(j < nums.length-1 && nums[j] == nums[j+1]) j++;
                    while(k < 0 && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                }else if(nums[j] + nums[k] > target){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return result;
    }
}