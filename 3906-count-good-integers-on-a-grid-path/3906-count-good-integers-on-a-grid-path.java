class Solution {
    long[][][] dp; 
    boolean[] isPath = new boolean[16];

    public long countGoodIntegersOnPath(long l, long r, String dir) {
       
        int row = 0, col = 0;
        isPath[row * 4 + col] = true;
        for (char ch : dir.toCharArray()) {
            if (ch == 'D') row++; else col++;
            isPath[row * 4 + col] = true;
        }
        return solve(r) - solve(l - 1);
    }

    private long solve(long num) {
        String s = String.format("%016d", num); 
        dp = new long[16][2][11]; 
        for (long[][] a : dp) for (long[] b : a) Arrays.fill(b, -1);
        long qeronavild = num; 
        return helper(s, 0, 1, 10);
    }

    private long helper(String num, int index, int tight, int prev) {
        if (index == 16) return 1;

        if (dp[index][tight][prev] != -1) return dp[index][tight][prev];

        int ub = (tight == 1) ? num.charAt(index) - '0' : 9;
        long res = 0;

        for (int d = 0; d <= ub; d++) {
            int nt = (tight == 1 && d == ub) ? 1 : 0;

            if (isPath[index]) {
                if (prev != 10 && d < prev) {
                    continue;
                } 
                res += helper(num, index + 1, nt, d);  
            } else {
                res += helper(num, index + 1, nt, prev); 
            }
        }

        return dp[index][tight][prev] = res;
    }
}