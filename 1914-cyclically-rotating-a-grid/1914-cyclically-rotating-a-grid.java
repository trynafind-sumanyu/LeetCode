class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int min = Math.min(m,n);

        for(int i = 0;i<min/2;i++){
            rot(grid,0+i,0+i,m-1-i,n-1-i,k);
        }
        return grid;
    }

    private void rot(int[][] grid, int rS, int cS, int rE, int cE, int k){
        int l = rE - rS+1;
        int b = cE - cS + 1;

        k = k%(2*(l+b)-4);

        while(k-- > 0){
            int temp = grid[rS][cS];
            for(int i = cS;i<cE;i++){
                grid[rS][i] = grid[rS][i+1];
            }
            for(int i = rS;i<rE;i++){
                grid[i][cE] = grid[i+1][cE];
            }
            for(int i = cE;i>cS;i--){
                grid[rE][i] = grid[rE][i-1];
            }
            for(int i = rE;i>rS;i--){
                grid[i][cS] = grid[i-1][cS];
            }
            if(rS+1 <= rE){
                grid[rS+1][cS] = temp;
            }
        }

    }
}