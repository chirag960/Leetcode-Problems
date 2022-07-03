class Solution {
    public int maxArea(int[] height) {
       int currArea, maxArea = 0;
        int left=0, right=height.length-1;
        while(left<right){
            currArea = Math.min(height[left], height[right]) * (right-left);
            maxArea = Math.max(currArea,maxArea);
            if(height[left]>height[right])
                right--;
            else
                left++;
        }
        return maxArea;
    }
}