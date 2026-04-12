class Solution {
    public int[] findDegrees(int[][] g) {
        int v = g.length;
        int[] edge = new int[v];
        for(int i = 0;i<v;i++){
            for(int j = 0;j<v;j++){
                if(g[i][j] == 1){
                    edge[j]++;
                }
            }
        }
        return edge;
    }
}