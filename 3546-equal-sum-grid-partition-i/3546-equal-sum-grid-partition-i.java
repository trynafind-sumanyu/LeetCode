class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalColSum = 0;
        long totalRowSum = 0;
        long[] rowSum = new long[m];
        long[] colSum = new long[n];

        for(int i = 0;i < m ; i++){
            long row = 0;
            for(int j = 0;j<n;j++){
                row += grid[i][j];
                totalRowSum += grid[i][j];
            }
            rowSum[i] = row;
        }
        for(int i = 0;i < n ; i++){
            long col = 0;
            for(int j = 0;j<m;j++){
                col += grid[j][i];
                totalColSum += grid[j][i];
            }
            colSum[i] = col;
        }

        long preCol = colSum[0];

        for(int i = 1;i<n;i++){
            if(totalColSum - preCol == preCol){
                return true;
            }
            preCol += colSum[i];
        }

        long preRow = rowSum[0];

        for(int i = 1;i <m;i++){
            if(totalRowSum - preRow == preRow){
                return true;
            }
            preRow += rowSum[i];
        }
        return false;
    }
}