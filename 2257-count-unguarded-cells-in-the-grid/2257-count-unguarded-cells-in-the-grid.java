class Solution {
    
    private static final int UNGUARDED = 0;
    private static final int GUARDED = 1;
    private static final int GUARD = 2;
    private static final int WALL = 3;
    
    public void backtrack(int[][] grid, int row, int col, int direction) {
        if(row < 0 ||
           col < 0 || 
           row >= grid.length || 
           col>=grid[0].length || 
           grid[row][col] == GUARD || 
           grid[row][col] == WALL
          ) {
            return;
        }
        
        grid[row][col] = GUARDED;
        if(direction == 'U') backtrack(grid, row - 1, col, 'U');
        if(direction == 'D') backtrack(grid, row + 1, col, 'D');
        if(direction == 'L') backtrack(grid, row, col - 1, 'L');
        if(direction == 'R') backtrack(grid, row, col + 1, 'R');
    }
    
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        for(int[] guard : guards) {
            grid[guard[0]][guard[1]] = GUARD;
        }
        
        for(int[] wall : walls) {
            grid[wall[0]][wall[1]] = WALL;
        }
        
        for(int[] guard : guards) {
            backtrack(grid, guard[0]-1, guard[1], 'U');
            backtrack(grid, guard[0]+1, guard[1], 'D');
            backtrack(grid, guard[0], guard[1]-1, 'L');
            backtrack(grid, guard[0], guard[1]+1, 'R');
        }
        
        int ans = 0;
        
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == UNGUARDED)
                    ans++;
            }
        }
        return ans;
    }
    
    
}