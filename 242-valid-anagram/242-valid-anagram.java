class Solution {
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        String sortedS = String.valueOf(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);
        String sortedT = String.valueOf(tc);
        return (sortedS.equals(sortedT));
    }
}