class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0, right = 0;
        int[] output = new int[nums.length - k + 1];
        int out_index = 0;
        Deque<Integer> deck = new ArrayDeque<>();

        while(right < nums.length){

            //remove smaller values from end
            while(deck.size() > 0 && nums[deck.peekLast()] < nums[right]){
                deck.pollLast();
            }
            deck.offer(right);

            //remove 1 left element
            if (left > deck.getFirst()){
                deck.pollFirst();
            }

            if(right + 1 >= k){
                output[out_index++] = nums[deck.peek()];
                left++;
            }

            right++;

        }

        return output;
    }
}