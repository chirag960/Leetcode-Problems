class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int left=0,right=0;
        int maxFrequency = 0;
        int result=0;
        for(right=0; right< s.length();right++){
            maxFrequency = Math.max(maxFrequency, ++frequency[s.charAt(right) - 'A']);
            while(right - left + 1 - maxFrequency > k){
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}