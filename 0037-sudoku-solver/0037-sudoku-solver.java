class Solution {
    public void solveSudoku(char[][] board){
        solve(board,0,0);
    }

    public boolean solve(char[][] board,int row,int col){
        if(row == board.length){
            return true;
        }

        if(col == board.length){
            return solve(board,row+1,0);


        }
        char[][] ans = new char[board.length][board.length];
        if(board[row][col] == '.'){
            for(int i = 1;i<10;i++){
                if(isSafe(board,row,col,i)){
                    board[row][col]=(char)(i+'0');
                    if(solve(board,row,col+1)){
                        return true;
                    }
                    board[row][col]='.';
                }
            }
            return false;
        }
        else{
            return solve(board,row,col+1);
        }
    }

    private boolean isSafe(char[][] board,int row,int col,int num){

        int n = (int)Math.sqrt(board.length);

        //For col

        for (char[] chars : board) {
            if (chars[col] == (char) (num + '0')) {
                return false;
            }
        }

        //For row
        for(int i = 0;i<board.length;i++){
            if(board[row][i]==(char)(num+'0')){
                return false;
            }
        }

        //For box

        for(int i = (row-row%3);i<(row-row%3)+3;i++){
            for(int j = (col-col%3);j<(col-col%3)+3;j++){
                if(board[i][j]==(char)(num+'0')){
                    return false;
                }
            }
        }
        return true;
    }
}