class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j>i){
                    int temp = matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=temp;
                }                
            }
        }
        for (int i=0;i<n;i++){
            matrix[i]=rev(matrix[i]);
        }
    }
    int[] rev(int[] arr){
        for(int i=0;i<arr.length/2;i++){
            int temp = arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
        return arr;
    }
}