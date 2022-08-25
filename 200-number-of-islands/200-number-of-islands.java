class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] v = new boolean[grid.length][grid[0].length];
        ArrayList<int[]> q = new ArrayList<int[]>();
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !v[i][j]){
                    bfs(grid,i,j,v,q);
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void bfs(char[][] grid, int i, int j, boolean v[][], ArrayList<int[]> q){
        v[i][j] = true;
        if(i>0 && grid[i-1][j]=='1' && !v[i-1][j]){
            bfs(grid,i-1,j,v,q);
        }
        if(j>0 && grid[i][j-1]=='1' &&!v[i][j-1]){
            bfs(grid,i,j-1,v,q);
        }
        if(i<grid.length-1 && grid[i+1][j]=='1' && !v[i+1][j]){
            bfs(grid,i+1,j,v,q);
        }
        if(j<grid[0].length-1 && grid[i][j+1]=='1' && !v[i][j+1]){
            bfs(grid,i,j+1,v,q);
        }
    }
}