class Solution {
    public boolean isValidSudoku(char[][] board) {
        return colCheck(board) && rowCheck(board) && boxCheck(board);
    }

    //Column Check
    boolean colCheck(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                for(int k=0;k<9;k++){
                    if(board[k][i] == 46 || k==j){
                        continue;
                    }
                    if (board[j][i]==board[k][i]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Row Check
    boolean rowCheck(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<8;j++){
                for(int k=j+1;k<9;k++){
                    if(board[i][k] == 46){
                        continue;
                    }
                    if (board[i][j]==board[i][k]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Box Check
    boolean boxCheck(char[][] board){
        for(int boxRow=0; boxRow<3; boxRow++){
            for(int boxCol=0; boxCol<3; boxCol++){
                // each 3×3 box
                for(int i=0; i<9; i++){       // pick one cell in box
                    for(int j=0; j<9; j++){   // compare with another cell in box
                        int r1 = boxRow*3 + i/3;
                        int c1 = boxCol*3 + i%3;
                        int r2 = boxRow*3 + j/3;
                        int c2 = boxCol*3 + j%3;
                        if(i==j || board[r1][c1]=='.' || board[r2][c2]=='.'){
                            continue;
                        }
                        if(board[r1][c1] == board[r2][c2]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}