class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        k = k%col;

        if(k == 0){
            return true;
        }

        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(i%2==0){
                    if(mat[i][j] != mat[i][(j+k)%col]){
                        return false;
                    }
                }
                else {
                    if(mat[i][j] != mat[i][(j-k+col)%col]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}