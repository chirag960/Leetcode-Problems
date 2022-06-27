class Solution {
    public int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n.length();i++){
            int a = Character.getNumericValue(n.charAt(i));
            max = Math.max(max,a);
        }
        return max;
    }
}