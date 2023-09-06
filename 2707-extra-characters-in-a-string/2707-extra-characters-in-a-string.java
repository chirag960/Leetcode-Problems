class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int dp[] = new int[s.length() + 1];
        
        Arrays.fill(dp, s.length() + 1);
        dp[0] = 0;

        Set<String> set = new HashSet<>(Arrays.asList(dictionary));

        for(int i=1;i <= s.length(); i++) {
            dp[i] = dp[i-1] + 1;
            for(int left = 1; left <= i; left++) {
                if(set.contains(s.substring(i-left, i))){
                    dp[i] = Math.min(dp[i], dp[i-left]);
                }
            }
        }
        return dp[s.length()];
    }
}