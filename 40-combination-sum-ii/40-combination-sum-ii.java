class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }
    
    public void backtrack(ArrayList<Integer> list, int[] candidates, int target, int sum, int start){
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=start; i<candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            if(sum + candidates[i] <= target){
                list.add(candidates[i]);
                backtrack(list, candidates, target, sum+candidates[i], i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}