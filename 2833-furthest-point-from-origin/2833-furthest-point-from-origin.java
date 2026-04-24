class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int right = 0;
        int left = 0;
        int under = 0;

        for(int i = 0;i<moves.length();i++){
            if(moves.charAt(i) == 'L'){
                left++;
            }
            if(moves.charAt(i)== 'R'){
                right++;
            }
            if(moves.charAt(i) == '_'){
                under++;
            }
        }
        int ans = 0;
        if(left > right){
            ans = left-right;
        }
        else if(right > left){
            ans = right - left;
        }

        return ans + under;
    }
}