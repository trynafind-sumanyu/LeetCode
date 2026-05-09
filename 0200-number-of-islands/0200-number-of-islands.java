class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] v = new boolean[m][n];

        for(boolean[] r : v){
            Arrays.fill(r,false);
        }
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                char c = grid[i][j];

                if(c == '1'){
                    if(!v[i][j]){
                        count++;
                        dfs(grid,v,i,j);
                    }
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] v,int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i > m-1 || j > n-1){
            return;
        }

        v[i][j] = true;

        if(i < m-1){
            if(grid[i+1][j] == '1'){
                if(!v[i+1][j]){
                    dfs(grid,v,i+1,j);
                }
            }
        }
        if(j < n-1){
            if(grid[i][j+1] == '1'){
                if(!v[i][j+1]){
                    dfs(grid,v,i,j+1);
                }
            }
        }
        if(i > 0){
            if(grid[i-1][j] == '1'){
                if(!v[i-1][j]){
                    dfs(grid,v,i-1,j);
                }
            }
        }
        if(j>0){
            if(grid[i][j-1] == '1'){
                if(!v[i][j-1]){
                    dfs(grid,v,i,j-1);
                }
            }
        }
    }
}