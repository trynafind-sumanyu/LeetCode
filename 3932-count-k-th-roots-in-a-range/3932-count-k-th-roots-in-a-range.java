class Solution {
    public int countKthRoots(int l, int r, int k) {
        int ans = 0;
        if(k == 1){
           return r-l+1; 
        }
        for(int i = 0;(int)Math.pow(i,k)<=r;i++){
            if((int)Math.pow(i,k) >= l){
                ans++;
            }
        }

        return ans;
    }
}