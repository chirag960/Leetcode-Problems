class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i : stones){
            queue.add(i);
        }
        
        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            if(a != b){
                queue.add(a-b);
            }
        }
        
        return queue.isEmpty() ? 0 : queue.peek();
        
    }
}