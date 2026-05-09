class Solution {
    public int[][] floodFill(int[][] g, int sr, int sc, int c) {
        int m = g.length;
        int n = g[0].length;

        boolean[][] v = new boolean[m][n];
        int p = g[sr][sc];
        dfs(g,sr,sc,c,p,v);
        return g;
        
    }

    private void dfs(int[][] g, int r, int c, int u,int p, boolean[][] v){
        int m = g.length;
        int n = g[0].length;
        if(r > m - 1 || c > n - 1){
            return;
        }

        v[r][c] = true;
        g[r][c] = u;

        if(r+1<m){
            if(g[r+1][c]==p){
                if(!v[r+1][c]){
                    dfs(g,r+1,c,u,p,v);
                }
            }
        }
        if(r>0){
            if(g[r-1][c]==p){
                if(!v[r-1][c]){
                    dfs(g,r-1,c,u,p,v);
                }
            }
        }
        if(c+1<n){
            if(g[r][c+1]==p){
                if(!v[r][c+1]){
                    dfs(g,r,c+1,u,p,v);
                }
            }
        }
        if(c>0){
            if(g[r][c-1]==p){
                if(!v[r][c-1]){
                    dfs(g,r,c-1,u,p,v);
                }
            }
        }
    }
}