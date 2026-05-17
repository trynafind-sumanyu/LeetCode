class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        char[] d = s.toCharArray();
        for(int i = 0;i<s.length()-1;i++){
            int a = Integer.parseInt(String.valueOf(d[i]));
            int b = Integer.parseInt(String.valueOf(d[i+1]));
            if(Math.abs(a-b) > 2){
                return false;
            }
        }
        return true;
    }
}