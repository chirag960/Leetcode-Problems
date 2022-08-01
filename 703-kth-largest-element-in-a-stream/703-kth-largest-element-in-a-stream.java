class KthLargest {

    Queue<Integer> queue;
    final int size;
    
    public KthLargest(int k, int[] nums) {
    
        queue = new PriorityQueue<>();
        size = k;
        
        for(int i : nums){
            if(queue.size() < k)
                queue.add(i);
            else{
                if(queue.peek() < i){
                    queue.poll();
                    queue.add(i);
                }
            }
        }
        
    }
    
    public int add(int val) {
        if(queue.size() < size){
            queue.add(val);   
        }        
        else if(queue.peek() < val){
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */