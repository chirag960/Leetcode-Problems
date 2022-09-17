class Solution {
    public String longestPalindrome(String s) {
        String res = s.substring(0,1);
        int maxLength = 1;
        for(int i=0;i<s.length();i++){
            int right = i+1;
            int left = i-1;
            while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){
                if((right - left + 1) > maxLength){
                    maxLength = right-left+1;
                    res = s.substring(left, right+1);
                }
                right++;
                left--;
            }
            
            right = i;
            left = i-1;
            while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)){
                if((right - left + 1) > maxLength){
                    maxLength = right-left+1;
                    res = s.substring(left, right+1);
                }
                right++;
                left--;
            }
            
        }
        return res;
    }
}