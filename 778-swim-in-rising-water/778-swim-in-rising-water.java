class Solution {
    public int swimInWater(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] minTime = new int[rows][cols];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                minTime[i][j] = Integer.MAX_VALUE;
            }
        }
        
        minTime[0][0] = grid[0][0];
        
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(0,0,grid[0][0])));
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                List<Integer> cell = q.remove();
                int row = cell.get(0);
                int col = cell.get(1);
                int time = cell.get(2);
                
                if(row-1 > -1 && (Math.max(time,grid[row-1][col]) < minTime[row-1][col])){
                    minTime[row-1][col] = Math.max(time,grid[row-1][col]);
                    q.add(new ArrayList<>(Arrays.asList(row-1,col,minTime[row-1][col])));
                }
                if(row+1 < rows  && (Math.max(time,grid[row+1][col]) < minTime[row+1][col])){
                    minTime[row+1][col] = Math.max(time,grid[row+1][col]);
                    q.add(new ArrayList<>(Arrays.asList(row+1,col,minTime[row+1][col])));
                }
                if(col-1 > -1 && (Math.max(time,grid[row][col-1]) < minTime[row][col-1])){
                    minTime[row][col-1] = Math.max(time,grid[row][col-1]);
                    q.add(new ArrayList<>(Arrays.asList(row,col-1,minTime[row][col-1])));
                }
                if(col+1 < cols && (Math.max(time,grid[row][col+1]) < minTime[row][col+1])){
                    minTime[row][col+1] = Math.max(time,grid[row][col+1]);
                    q.add(new ArrayList<>(Arrays.asList(row,col+1,minTime[row][col+1])));
                }
            }
            
            
        }
        
        return minTime[rows-1][cols-1];
        
    }
}