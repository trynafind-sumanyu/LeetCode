class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {

        int n = monsters.length;

        long[] diff = new long[n];

        for (int[] boost : boosts) {
            int l = boost[0], r = boost[1], v = boost[2];

            diff[r] += v;
            if (l > 0) {
                diff[l - 1] -= v;
            }
        }
        long ans = 0;
        long bonus = 0;

        for (int i = n - 1; i >= 0; i--) {
            bonus += diff[i];
            if (ans > 0) {
                ans += monsters[i];
            } else {
                ans = Math.max(0L, monsters[i] - bonus);
            }
        }
        return ans;
    }
}
