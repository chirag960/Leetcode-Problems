class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groups = new HashMap<>();
        for(String s : strs){
            char[] sCharArray = s.toCharArray();
            Arrays.sort(sCharArray);
            String sortedS = String.valueOf(sCharArray);
            if(groups.containsKey(sortedS)){
                List<String> group = groups.get(sortedS);
                group.add(s);
                groups.put(sortedS, group);
            }else{
                List<String> group = new ArrayList<>();
                group.add(s);
                groups.put(sortedS, group);
            }
        }

        return new ArrayList(groups.values());
    }
}