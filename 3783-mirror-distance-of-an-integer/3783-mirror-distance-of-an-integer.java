class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n-rev(n));
    }

    private int rev(int n){
        int ans = 0;
        while(n > 0){
            ans = ans*10 + n%10;
            n = n/10;
        }
        return ans;
    }
}