class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<List<Integer>> rotten = new LinkedList<>();
        
        int totalFresh = 0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    rotten.offer(Arrays.asList(i,j));
                }
                if(grid[i][j] == 1){
                    totalFresh++;
                }
            }
        }
        System.out.println("total fresh is " + totalFresh);
        int time = 0;
        int currRotten = 0;
        
        while(!rotten.isEmpty()){
            int size = rotten.size();
            for(int i=0;i<size;i++){
                List<Integer> indices = rotten.poll();
                int row = indices.get(0);
                int col = indices.get(1);
                if(col > 0 && grid[row][col-1] == 1){
                    grid[row][col-1] = 2;
                    rotten.offer(Arrays.asList(row, col-1));
                    currRotten++;
                    System.out.println("Found at " + row + " " + (col-1));
                }
                if(row > 0 && grid[row-1][col] == 1){
                    grid[row-1][col] = 2;
                    rotten.offer(Arrays.asList(row-1, col));
                    currRotten++;
                    System.out.println("Found at " + (row-1) + " " + col);
                }
                if(col < grid[0].length-1 && grid[row][col+1] == 1){
                    grid[row][col+1] = 2;
                    rotten.offer(Arrays.asList(row, col+1));
                    currRotten++;
                    System.out.println("Found at " + row + " " + (col+1));
                }
                if(row < grid.length-1 && grid[row+1][col] == 1){
                    grid[row+1][col] = 2;
                    rotten.offer(Arrays.asList(row+1, col));
                    currRotten++;
                    System.out.println("Found at " + (row+1) + " " + col);
                }
            }
            System.out.println("incrementing time");
            if(!rotten.isEmpty()){
                time++;    
            }
        }
        
        return currRotten == totalFresh ? time : -1;
        
    }
}