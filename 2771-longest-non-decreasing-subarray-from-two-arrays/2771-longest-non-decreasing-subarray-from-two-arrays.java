class Solution {
    public int maxNonDecreasingLength(int[] a, int[] b) {
        int res = 1;
        int dp1 = 1;
        int dp2 = 1;
        int n = a.length;
        
        for (int i = 1; i < n; ++i) {
            int t11 =  a[i - 1] <= a[i] ? dp1 + 1 : 1;
            int t12 = a[i - 1] <= b[i] ? dp1 + 1 : 1;
            int t21 = b[i - 1] <= a[i] ? dp2 + 1 : 1;
            int t22 = b[i - 1] <= b[i] ? dp2 + 1 : 1;
            dp1 = Math.max(t11, t21);
            dp2 = Math.max(t12, t22);
            res = Math.max(res, Math.max(dp1, dp2));
        }
        return res;
    }
}