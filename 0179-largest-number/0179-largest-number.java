class Solution {
    public String largestNumber(int[] nums) {
        String[] n = new String[nums.length];
        
        for(int i=0;i<nums.length;i++){
            n[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(n, (a, b) -> (b + a).compareTo(a + b));
        
        if(n[0].equals("0")){
            return "0";
        }
        
        StringBuilder ans = new StringBuilder();
        for(String s : n){
            ans.append(s);
        }
        
        return ans.toString();
    }
}