class Solution {
    
    int mod = (int)Math.pow(10,9) + 7;
    
    public int numRollsToTarget(int n, int k, int target) {
        int sum = 0;
        Integer[][] dp = new Integer[target+1][n+1];
        for(int i=1;i<=k;i++){
            sum = (sum%mod + recur(k,target-i,n-1,dp)%mod)%mod;
        }
        return sum;
    }
    
    public int recur(int k, int r, int dr, Integer dp[][]){
        //System.out.println("calling for " + k + " " + r + " " + dr);
        if(r < 0){
            return 0;
        }
        if(dp[r][dr] != null){
            //System.out.println("not null");
            return dp[r][dr];
        }
        if(r==0 && dr==0){
            //System.out.println("1");
            return 1;
        }
        if(dr < 1){
            return 0;
        }
        if(r < 0){
            return 0;
        }
        int sum = 0;
        if(dr > 0){
            for(int i=1;i<=k;i++){
                if(r-i >=0 && dr-1 >= 0){
                    dp[r-i][dr-1] = recur(k,r-i,dr-1,dp)%mod;    
                    sum = (sum%mod + (dp[r-i][dr-1])%mod)%mod;
                }
            }
        }
        dp[r][dr] = sum;
        return sum;
    }
}