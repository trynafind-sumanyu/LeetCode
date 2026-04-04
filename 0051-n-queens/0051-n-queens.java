class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return totalQueens(board,0);
    }

    private List<List<String>> totalQueens(boolean[][] board, int row) {
        List<List<String>> ans = new ArrayList<>();
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            ans.add(lst(board,list));
            return ans;
        }
        //placing the queen and checking for every row and col
        for (int col = 0; col < board.length; col++) {
            //place the queen if it's safe
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                ans.addAll(totalQueens(board,row + 1));
                board[row][col] = false;
            }
        }

        return ans;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical row
        for (int i = 0;i<row;i++){
            if(board[i][col]){
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row,col);
        for (int i = 1; i<=maxLeft;i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        //diagonal right
        int maxRight = Math.min(row,board.length-col-1);
        for(int i = 1;i<=maxRight;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    
    private List<String> lst(boolean[][] board, List<String> list){
        for(boolean[] row : board){
            StringBuilder p = new StringBuilder();
            for(boolean element : row){
                if(element){
                    p.append("Q");
                }
                else {
                    p.append(".");
                }
            }
            list.add(p.toString());
        }
        return list;
    }
}