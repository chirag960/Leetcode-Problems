class Solution {
    
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recur(new ArrayList<Integer>(), candidates, 0, 0, target);
        return new ArrayList<List<Integer>>(result);
    }
    
    public void recur(List<Integer> subset,int[] candidates, int index, int sum, int target){
        if(sum == target){
            result.add(subset);
            return;
        }
        if(sum > target){
            return;
        }
        if(index >= candidates.length){
            return;
        }
        
        List<Integer> excludeSet = new ArrayList<>(subset);
        recur(excludeSet, candidates, index+1, sum, target);
        
        sum = sum + candidates[index];
        List<Integer> currSet = new ArrayList<>(subset);
        currSet.add(candidates[index]);
        recur(currSet, candidates, index, sum, target);
        
        List<Integer> anotherSet = new ArrayList<>(currSet);
        recur(anotherSet, candidates, index+1, sum, target);
        
    }
    
    
}