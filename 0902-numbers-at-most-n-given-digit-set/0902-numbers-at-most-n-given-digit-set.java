class Solution {

    int[][][] dp = new int[10][2][2];


    public int atMostNGivenDigitSet(String[] digits, int n) {
        int mask = 0;
        for (String dig : digits) {
            mask = mask | (1 << Integer.parseInt(dig));
        }

        for(int[][] x : dp){
            for(int[] y : x){
                Arrays.fill(y, -1);
            }
        }
        String num = String.valueOf(n);
        // solve - 1 cause a digit with all 0's will form always and will result into an extra ans
        return solve(num, 0, 1, mask,1)-1;
    }

    private int solve(String num, int index, int tight, int mask,int lz) {
        if (index == num.length()) {
            return 1;
        }

        if(dp[index][tight][lz] != -1){
            return dp[index][tight][lz];
        }

        int lb = 0;
        int ub = (tight == 1) ? num.charAt(index) - '0' : 9;
        int res = 0;
        for (int dig = lb; dig <= ub; dig++) {
            int newTight = (tight == 1 && dig == ub) ? 1 : 0;
            if(lz == 1 && dig == 0){
                res += solve(num,index+1,0,mask,1);
            }
            if (((mask>>dig)&1) == 1){
                res += solve(num,index + 1,newTight,mask,0);
            }
        }

        return dp[index][tight][lz] = res;
    }
}