class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            count++;
            int right = i+1;
            int left = i-1;
            while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){
                count++;
                right++;
                left--;
            }
            
            right = i;
            left = i-1;
            while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){
                count++;
                right++;
                left--;
            }
            
        }
        return count;
    }
}