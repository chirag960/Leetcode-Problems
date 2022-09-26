class Solution {
    
    int[] parents = IntStream.range(0, 26).toArray();
    public boolean equationsPossible(String[] equations) {
        for(String s : equations){
            if(s.charAt(1) == '='){
                parents[find(s.charAt(0)-'a')] = find(s.charAt(3) - 'a');
            }
        }
        
        for(String s : equations){
            if(s.charAt(1) == '!'){
                if(parents[find(s.charAt(0)-'a')] == parents[find(s.charAt(3)-'a')]){
                    return false;
                }
            }
        }
        return true;
    }
    
    public int find(int a){
        if(parents[a] != a){
            parents[a] = find(parents[a]);
        }
        return parents[a];
    }
}