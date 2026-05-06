class Solution {
    public int numWaterBottles(int b, int k) {
        int ans = b;

        while(b/k > 0){
            ans += b/k;
            b = b/k + b%k;
        }
        return ans;
    }
}