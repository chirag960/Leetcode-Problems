class Solution {
    
    public List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        recur(new ArrayList<Integer>(), nums, 0);
        return result;
    }
    
    public void recur(List<Integer> subset, int[] nums, int index){
        if(index == nums.length){
            result.add(subset);
            return;
        }
        
        List<Integer> currSubset = new ArrayList<>(subset);
        recur(currSubset, nums, index+1);
        
        List<Integer> anotherSubset = new ArrayList<>(currSubset);
        anotherSubset.add(nums[index]);
        recur(anotherSubset, nums, index+1);
    }
}