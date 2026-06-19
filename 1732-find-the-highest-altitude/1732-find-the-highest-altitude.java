class Solution {
    public int largestAltitude(int[] gain) {
        int[] ans  = new int[gain.length+1];
        ans[0]=0;
        for (int i=1;i<ans.length;i++){
            ans[i]=ans[i-1]+gain[i-1];
        }
        int max = ans[0];
        for (int num: ans){
            max = Math.max(max,num);
        }
        return max;
    }
}