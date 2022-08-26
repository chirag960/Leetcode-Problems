class Solution {
    
    int max = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    max = Math.max(bfs(grid, visited, i, j), max);
                }
            }
        }
        
        return max;
        
    }
    
    public int bfs(int[][] grid, boolean[][] visited, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return 0;
        }        
        if(visited[i][j] || grid[i][j] != 1){
            return 0;
        }
        
        visited[i][j] = true;
        return 1 + bfs(grid, visited, i+1, j)
        + bfs(grid, visited, i, j+1)
        + bfs(grid, visited, i-1, j)
        + bfs(grid, visited, i, j-1);
        
        
    }
}