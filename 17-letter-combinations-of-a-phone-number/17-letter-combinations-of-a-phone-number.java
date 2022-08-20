class Solution {
    
    Map<Integer, Character[]> map;
    List<String> result = new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0){
            return result;
        }
        
        map = new HashMap<>();
        map.put(2, new Character[]{'a','b','c'});
        map.put(3, new Character[]{'d','e','f'});
        map.put(4, new Character[]{'g','h','i'});
        map.put(5, new Character[]{'j','k','l'});
        map.put(6, new Character[]{'m','n','o'});
        map.put(7, new Character[]{'p','q','r','s'});
        map.put(8, new Character[]{'t','u','v'});
        map.put(9, new Character[]{'w','x','y','z'});
        
        Character[] c = map.get(Character.getNumericValue(digits.charAt(0)));
        
        for(int i=0;i<c.length;i++){
            recur(digits, new StringBuilder().append(c[i]), 1);
        }
        
        return result;
        
    }
    
    public void recur(String digits, StringBuilder str, int index){
        if(str.length() == digits.length()){
            result.add(str.toString());
            return;
        }
        Character[] c = map.get(Character.getNumericValue(digits.charAt(index)));
        
        for(int i=0;i<c.length;i++){
            recur(digits, str.append(c[i]), index+1);
            str.deleteCharAt(str.length() - 1);
        }
        
    }
    
}