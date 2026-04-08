class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        if (solve(grid)) {
            return true;
        }

        int[][] ans = transpose(grid);
        return solve(ans);
    }

    public int[][] transpose(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] ans = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][i] = grid[i][j];
            }
        }
        return ans;
    }

    private boolean solve(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        long bottomSum = 0;
        long topSum = 0;

        int[] bottomFreq = new int[100001];
        int[] topFreq = new int[100001];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                bottomSum += grid[i][j];
                bottomFreq[grid[i][j]]++;
            }
        }

        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c; j++) {
                bottomSum -= grid[i][j];
                bottomFreq[grid[i][j]]--;
                topSum += grid[i][j];
                topFreq[grid[i][j]]++;
            }
            if (topSum == bottomSum) {
                return true;
            }

            long diffTop = (topSum - bottomSum);

            if (diffTop > 0 && diffTop <= 100000) {
                int dt = (int)diffTop;
                int h = i + 1;
                int w = c;
                if (h > 1 && w > 1) {
                    if (topFreq[dt] > 0) {
                        return true;
                    }
                } else if (h > 1 && w == 1) {
                    if (grid[0][0] == dt || grid[i][0] == dt) {
                        return true;
                    }
                } else if (h == 1 && w > 1) {
                    if (grid[0][0] == dt || grid[0][w - 1] == dt) {
                        return true;
                    }
                }
            }

            long diffBot = (bottomSum - topSum);

            if (diffBot > 0 && diffBot <= 100000) {
                int db = (int)diffBot;
                int h = r - i - 1;
                int w = c;
                if (h > 1 && w > 1) {
                    if (bottomFreq[db] > 0) {
                        return true;
                    }
                } else if (h > 1 && w == 1) {
                    if (grid[i + 1][0] == db || grid[r - 1][0] == db) {
                        return true;
                    }
                } else if (h == 1 && w > 1) {
                    if (grid[r - 1][0] == db || grid[r - 1][w - 1] == db) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}