class Solution {
    public boolean validTicTacToe(String[] board) {
        int zeroes = 0;
        int xes = 0;
        boolean diagCheckX = false;
        boolean diagCheckO = false;
        boolean rowCheckX = false;
        boolean rowCheckO = false;
        boolean colCheckO = false;
        boolean colCheckX = false;
        for (String str : board) {
            int rowX = 0;
            int rowO = 0;
            for (int i = 0; i < 3; i++) {
                if (str.charAt(i) == 'O') {
                    zeroes++;
                    rowO++;
                }
                if (str.charAt(i) == 'X') {
                    xes++;
                    rowX++;
                }
            }
            if (rowX == 3) {
                rowCheckX = true;
            }
            if (rowO == 3) {
                rowCheckO = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            int colX = 0;
            int colO = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j].charAt(i) == 'X') {
                    colX++;
                }
                if (board[j].charAt(i) == 'O') {
                    colO++;
                }
            }
            if (colX == 3) {
                colCheckX = true;
                break;
            }
            if (colO == 3) {
                colCheckO = true;
                break;
            }
        }
        int[] diag1 = new int[2];
        int[] diag2 = new int[2];
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(i) == 'X') {
                diag1[0]++;
            }
            if (board[i].charAt(i) == 'O') {
                diag1[1]++;
            }
            if (board[i].charAt(2 - i) == 'X') {
                diag2[0]++;
            }
            if (board[i].charAt(2 - i) == 'O') {
                diag2[1]++;
            }
        }

        if (diag1[0] == 3 || diag2[0] == 3) {
            diagCheckX = true;
        }

        if (diag1[1] == 3 || diag2[1] == 3) {
            diagCheckO = true;
        }

        if (rowCheckX || colCheckX || diagCheckX) {
            if (zeroes == xes) {
                return false;
            }
        }

        if (rowCheckO || colCheckO || diagCheckO) {
            if (zeroes != xes) {
                return false;
            }
        }
        return xes == zeroes + 1 || xes == zeroes;
    }
}