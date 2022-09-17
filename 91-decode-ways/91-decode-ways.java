class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        
        Integer[] dp = new Integer[s.length()];
        recur(s, 0, dp);
        return dp[0];
        
    }
    
    public int recur(String s, int i, Integer[] dp){
        if(i >= s.length()){
            return 1;
        }
        
        if(s.charAt(i) == '0'){
            return 0;
        }
        
        if(dp[i] != null){
            return dp[i];
        }
        
        int count = 0;
        count += recur(s, i+1, dp);
        if(i < s.length()-1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')){
            count += recur(s, i+2, dp);
        }
        
        dp[i] = count;
        return dp[i];
    }
}