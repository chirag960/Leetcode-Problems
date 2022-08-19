class Solution {
    public boolean exist(char[][] board, String word) {
        for (int y=0; y<board.length; y++) {
    	    for (int x=0; x<board[0].length; x++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
    		    if (backtrack(board, word, visited, y, x, 0)) return true;
    	    }
        }
        return false;
    }
    
    public boolean backtrack(char[][] board, String word, boolean[][] visited, int row, int col, int index){
        //System.out.println("row " + row + " col " + col + " index " + index);
        //System.out.println(Arrays.deepToString(visited));
        if(row<0 || col<0 || row==board.length || col==board[0].length){
            return false;   
        }
        if((!visited[row][col]) && (board[row][col] == word.charAt(index)) && (index == word.length()-1)){
            //System.out.println("Matched, returning true");
            return true;
        }
        if(visited[row][col]){
            //System.out.println("row col visited");
            return false;
        }
        visited[row][col] = true;
        
        if(board[row][col] != word.charAt(index)){
            //System.out.println("char doenst match");
            visited[row][col] = false;
            return false;
        }
        
        boolean exist = backtrack(board, word, visited, row+1, col, index+1)
                    || backtrack(board, word, visited, row-1, col, index+1)
                    || backtrack(board, word, visited, row, col+1, index+1)
                    || backtrack(board, word, visited, row, col-1, index+1);
        
        visited[row][col] = false;
        return exist;
    }
    
}