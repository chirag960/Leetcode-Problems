class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for(int i : nums){
            frequencies.put(i, frequencies.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>( (a,b) -> a.getValue() - b.getValue());
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : frequencies.entrySet()){
            if(i++<k){
                queue.add(entry);
            }else{
                if (queue.peek().getValue() < entry.getValue()){
                    queue.remove();
                    queue.add(entry);
                }
            }
        }

        int[] ans = new int[k];
        i = 0;
        while(!queue.isEmpty()){
            ans[i++] = queue.remove().getKey();
        }

        return ans;
    }
}