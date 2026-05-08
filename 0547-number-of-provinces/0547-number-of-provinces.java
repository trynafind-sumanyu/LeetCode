class Solution {
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        List<List<Integer>> g = new ArrayList<>();

        for(int i = 0;i<n;i++){
            g.add(new ArrayList<>());
        }

        for(int i = 0;i< n;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 1 && i!=j){
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }

        boolean[] v = new boolean[n];
        int c = 0;

        for(int i = 0;i<n;i++){
            if(!v[i]){
                c++;
                dfs(g,v,i);
            }
        }
        return c;
    }

    private void dfs(List<List<Integer>> g, boolean[] v,int s){
        v[s] = true;

        for(int i : g.get(s)){
            if(!v[i]){
                dfs(g,v,i);
            }
        }
        return;
    }
}