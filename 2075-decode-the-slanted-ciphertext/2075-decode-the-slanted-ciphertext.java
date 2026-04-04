class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(encodedText.length()<rows){
            return "";
        }
        int col = encodedText.length()/rows;
        char[][] mat = new char[rows][col];
        int idx = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<col;j++){
                mat[i][j] = encodedText.charAt(idx);
                idx++;
            }
        }
        idx = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<col;i++){
            for(int r = 0;r<rows;r++){
                if((i+r)==col){
                    break;
                }
                ans.append(mat[r][i+r]);
            }
        }
        return ans.toString().stripTrailing();
    }
}