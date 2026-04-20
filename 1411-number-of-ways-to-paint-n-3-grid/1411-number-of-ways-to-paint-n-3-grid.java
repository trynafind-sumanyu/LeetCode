class Solution {
    public int numOfWays(int n) {
        int mod = (int)1e9+7;
        long a = 6;
        long b = 6;
        for(int i = 1;i<n;i++){
            long newA = (2*a + 2*b)%mod;
            long newB = (2*a + 3*b)%mod;
            a = newA;
            b = newB;
        }

        return (int)((a+b)%mod);
    }
}