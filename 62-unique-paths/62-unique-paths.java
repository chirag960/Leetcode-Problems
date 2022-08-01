class Solution {
    public int uniquePaths(int m, int n) {
        double big = Math.max(m-1,n-1);
        double small = Math.min(m-1,n-1);
        
        double numerator = 1;
        for(double i=big+small; i>big;i--){
            numerator*=i;
        }
        
        System.out.println(numerator);
        
        double d = 1;
        for(double i=small; i>1;i--){
            d*=i;
        }
        
        System.out.println(d);
        
        double ans = numerator/d;
        return (int)ans;
    }
}