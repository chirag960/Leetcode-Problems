class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        
        for(int i=0;i<heights[0].length;i++){
            dfs(heights, pacific, 0, i, -1);
        }
        
        for(int i=0;i<heights[0].length;i++){
            dfs(heights, atlantic, heights.length-1, i, -1);
        }
        
        for(int i=0;i<heights.length;i++){
            dfs(heights, pacific, i, 0, -1);
        }
        
        for(int i=0;i<heights.length;i++){
            dfs(heights, atlantic, i, heights[i].length-1, -1);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<heights.length; i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        
        return result;
    }
    
    public static void dfs(int[][] heights, boolean[][] visited, int i, int j, int prev){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length){
            return;
        }
        if(visited[i][j]){
            return;
        }
        if(heights[i][j] < prev){
            return;
        }
        visited[i][j] = true;
        dfs(heights, visited, i+1, j, heights[i][j]);
        dfs(heights, visited, i, j+1, heights[i][j]);
        dfs(heights, visited, i-1, j, heights[i][j]);
        dfs(heights, visited, i, j-1, heights[i][j]);
    }
}