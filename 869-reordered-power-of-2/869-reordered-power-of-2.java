class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] f = frequencyMap(n);
        for(int i=0;i<31;i++){
            if(Arrays.equals(f, frequencyMap(1 << i))){
                return true;
            }
        }
        return false;
    }
    
    public int[] frequencyMap(int n){
        int[] ans = new int[10];
        while(n > 0){
            ans[n%10]++;
            n/=10;
        }
        return ans;
    }
}