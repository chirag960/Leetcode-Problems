class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        
        int[] array2 = new int[26];
        for(String word : words2){
            int[] currWord = countFrequency(word);
            for(int i=0;i<26;i++){
                array2[i] = Math.max(array2[i], currWord[i]);
            }
        }
        
        for(String word : words1){
            int[] array1 = countFrequency(word);
            
            boolean isUniversal = true;
            for(int i=0;i<26;i++){
                if(array1[i] < array2[i]){
                    isUniversal = false;
                    break;
                }
            }
            
            if(isUniversal)
                result.add(word);
        }
        
        return result;
    }
    
    public int[] countFrequency(String s){
        int[] res = new int[26];
        for(char c : s.toCharArray()){
                res[c - 'a']++;
        }
        return res;
    }
}