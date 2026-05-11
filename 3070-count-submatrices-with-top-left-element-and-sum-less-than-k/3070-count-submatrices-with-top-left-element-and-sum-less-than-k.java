class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                long up = i > 0 ? grid[i-1][j] : 0;
                int left = j > 0 ? grid[i][j-1] : 0;
                int diagUp = (i > 0 && j > 0) ? grid[i-1][j-1] : 0;

                grid[i][j] = (int)(grid[i][j] + up + left - diagUp);

                if(grid[i][j] <= k){
                    ans++;
                }
                else{
                    if(j == 0){
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}