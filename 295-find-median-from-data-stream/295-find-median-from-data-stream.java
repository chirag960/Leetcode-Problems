class MedianFinder {
    
    Queue<Integer> small;
    Queue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>((a,b)-> b-a);
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(small.isEmpty()){
            small.add(num);
            return;
        }
        if(small.peek() > num){
            small.add(num);
        }else{
            large.add(num);
        }
        if(small.size() > large.size()+1){
            int i = small.poll();
            large.add(i);
        }else if(large.size() > small.size()+1){
            int i = large.poll();
            small.add(i);
        }
    }
    
    public double findMedian() {
        if(small.size() == large.size()){
            return (small.peek() + large.peek())/(double)2;
        }
        
        if(small.size() > large.size()){
            return small.peek();
        }else{
            return large.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */