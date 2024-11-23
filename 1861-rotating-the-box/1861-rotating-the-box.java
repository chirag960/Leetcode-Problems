class Solution {
    
    private final char STONE = '#';
    private final char OBSTACLE = '*';
    private final char EMPTY = '.';
    
    
    private char[] rotateRow(char[] row){
        int index = row.length - 1;
        for(int cell = row.length - 1; cell >= 0; cell--) {
            if(row[cell] == STONE) {
                row[index] = STONE;
                
                if(cell != index){
                    row[cell] = EMPTY;
                } 
                index--;
            }
            
            if(row[cell] == OBSTACLE){
                index = cell - 1;
            }
            
        }
        
        return row;
    }
    
    public char[][] rotateTheBox(char[][] box) {
        char[][] ans = new char[box[0].length][box.length];
        
        for(int i = 0; i < box.length; i++){
            char[] rotatedRow = rotateRow(box[i]);
            
            for(int j = 0; j < rotatedRow.length; j++){
                ans[j][box.length - i - 1] = rotatedRow[j];    
            }
            
        }
        
        return ans;
    }
}