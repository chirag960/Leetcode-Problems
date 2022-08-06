class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        
        int[] arr = new int[26];
        for(char task : tasks){
            arr[task - 'A']++;
        }
        
        for(int a : arr){
            if (a > 0){
                pq.add(a);
            }    
        }
        
        int time = 0;
        
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            
            if(!pq.isEmpty()){
                int val = pq.poll();
                val--;
                if(val > 0){
                    q.add(new Pair(val, time+n));
                }
            }
            if(!q.isEmpty() && q.peek().getValue() == time){
                pq.add(q.poll().getKey());
            }
        }
        return time;
    }
}