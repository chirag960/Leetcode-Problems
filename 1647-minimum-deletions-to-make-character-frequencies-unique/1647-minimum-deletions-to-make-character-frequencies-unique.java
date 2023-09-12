class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        int deletions = 0;
        Set<Integer> frequencies = new HashSet<>();
        
        for(Map.Entry<Character, Integer> e : frequencyMap.entrySet()){
            int f = e.getValue();
            while(frequencies.contains(f) && f!=0){
                f--;
                deletions++;
            }
            frequencies.add(f);
        }
        return deletions;
    }
}