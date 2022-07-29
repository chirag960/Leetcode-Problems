class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for(String word : words){
            Map<Character, Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            
            boolean isPattern = true;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(map.containsKey(c)){
                    if(map.get(c) != pattern.charAt(i)){
                        isPattern = false;
                        break;
                    }
                }else{
                    char val = pattern.charAt(i);
                    if(set.contains(val)){
                        isPattern = false;
                        break;
                    }else{
                        map.put(c, val);
                        set.add(val);
                    }
                }
            }
            if(isPattern){
                result.add(word);
            }
        }
        
        return result;
        
        
    }
}