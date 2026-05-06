class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int r = box.length;
        int c = box[0].length;

        for(char[] row : box){
            int index = 0;
            for(int i = 0;i<c;i++){
                if(row[i] == '#'){
                    continue;
                }
                if(row[i] == '*'){
                    index = i+1;
                    while(index < row.length && row[index] == '*') {
                        index++;
                    }
                    if(index == row.length){
                        break;
                    }
                }
                if(row[i] == '.'){
                    swap(row, i, index);
                    index++;
                }
            }
        }

        char[][] ans = new char[c][r];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                ans[j][i] = box[i][j];
            }
        }

        for(char[] row : ans){
            rev(row);
        }
        return ans;
    }

    private void rev(char[] r){
        for(int i = 0;i<r.length/2;i++){
            swap(r,i,r.length-i-1);
        }
    }

    private void swap(char[] box, int i, int j){
        char temp = box[i];
        box[i] = box[j];
        box[j] = temp;
    }
}