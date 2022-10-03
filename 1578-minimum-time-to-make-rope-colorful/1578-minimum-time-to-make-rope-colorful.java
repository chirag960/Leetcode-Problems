class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] colorsArr = colors.toCharArray();
        
        int ans = 0;
        int minTime = neededTime[0];
        int currSum = neededTime[0];
        boolean sameFlag = false;
        
        for(int i=1;i<colors.length();i++){
            if(colorsArr[i] == colorsArr[i-1]){
                sameFlag = true;
                currSum+=neededTime[i];
                minTime = Math.max(neededTime[i], minTime);
            }else{
                if(sameFlag){
                    ans+=(currSum-minTime);
                }
                sameFlag = false;
                currSum = neededTime[i];
                minTime = neededTime[i];
            }
        }
        if(sameFlag){
            ans+=(currSum-minTime);
        }
        return ans;
    }
}