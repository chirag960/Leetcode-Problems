class Solution {
public boolean isValidSudoku(char[][] board) {
        if(!isValidRows(board)){
            return false;
        }
        if(!isValidColumns(board)){
            return false;
        }
        if(!isValidBox(board)){
            return false;
        }
        return true;
    }

    public static boolean isValidRows(char[][] board) {
        for(int i=0;i<9;i++){
            HashSet<Character> set = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j] == '.')
                    continue;
                if(set.contains(board[i][j]))
                    return false;
                else
                    set.add(board[i][j]);
            }
        }
        return true;
    }

    public static boolean isValidColumns(char[][] board) {
        for(int j=0;j<9;j++){
            HashSet<Character> set = new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[i][j] == '.')
                    continue;
                if(set.contains(board[i][j]))
                    return false;
                else
                    set.add(board[i][j]);
            }
        }
        return true;
    }

    public static boolean isValidBox(char[][] board) {
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                char[] x = new char[9];
                x[0] = board[i][j];
                x[1] = board[i][j + 1];
                x[2] = board[i][j + 2];
                x[3] = board[i + 1][j];
                x[4] = board[i + 1][j + 1];
                x[5] = board[i + 1][j + 2];
                x[6] = board[i + 2][j];
                x[7] = board[i + 2][j + 1];
                x[8] = board[i + 2][j + 2];
                if (!checkValid(x)) {
                    return false;
                }
            }
        }
        return true;
    }

       public static boolean checkValid(char[] x){
            HashSet<Character> hs = new HashSet<Character>();
            for (int i = 0; i < x.length; i++){
                if (hs.contains(x[i]) && x[i] != '.'){
                    return false;
                }
                else{
                    hs.add(x[i]);
                }
            }
            return true;
        }
}