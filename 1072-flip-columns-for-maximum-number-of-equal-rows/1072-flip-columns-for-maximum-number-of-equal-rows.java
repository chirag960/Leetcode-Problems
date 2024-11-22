class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for(int[] row : matrix){
            StringBuilder patternBuilder = new StringBuilder();
            for(int i=0;i<row.length;i++){
                if(row[0] == row[i]){
                    patternBuilder.append("T");
                } else {
                    patternBuilder.append("F");
                }
            }
            
            String rowPattern = patternBuilder.toString();
            map.put(rowPattern, map.getOrDefault(rowPattern, 0) + 1);
        }
        
        int max = 0;
        for(int i : map.values()) {
            max = Math.max(i, max);
        }
        
        return max;
    }
}