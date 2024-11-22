class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        
        if(k==0) {
            return ans;
        }
        
        int currSum = 0;
        int left = 1;
        int right = k;
        
        if(k < 0) {
            left = code.length + k;
            right = code.length - 1;
        }
        
        for(int i = left; i <= right; i++){
                currSum += code[i];
        }
        
        for(int i = 0; i < code.length; i++) {
            ans[i] = currSum;
            currSum -= code[left];
            left = (left + 1) % code.length;
            right = (right + 1) % code.length;
            currSum += code[right];
        }
        
        return ans;
    }
}