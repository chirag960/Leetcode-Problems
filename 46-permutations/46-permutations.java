class Solution {
    
    List<List<Integer>> result =  new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {        
        backtrack(new ArrayList<>(), nums);
        return result;
    }
    
    public void backtrack(List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtrack(list, nums);
            list.remove(list.size() - 1);
        }
    }
}