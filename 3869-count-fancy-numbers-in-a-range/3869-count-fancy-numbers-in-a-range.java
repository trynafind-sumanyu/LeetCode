class Solution {
    long[][][][][][] dp;

    public long countFancy(long l, long r) {
        return helper(r) - helper(l-1);
    }

    private long helper(long x) {
        String num = String.valueOf(x);
        int n = num.length();
        dp = new long[n][2][4][200][2][11];

        for (long[][][][][] a : dp) {
            for (long[][][][] b : a) {
                for (long[][][] c : b) {
                    for (long[][] d : c) {
                        for (long[] e : d) {
                            Arrays.fill(e, -1);
                        }
                    }
                }
            }
        }

        return solve(num, 0,1,0,-1,0,0);
    }

    private long solve(String num, int index, int tight, int trend,int prev, int sum, int lz) {
        if (index == num.length()) {
            if(lz == 0){
                return 0;
            }
            if(trend == 1 || trend == 2 || trend == 0){
                return 1;
            }
            if(good(sum)){
                return 1;
            }
            return 0;
        }

        int li = prev+1;

        if(dp[index][tight][trend][sum][lz][li] != -1){
            return dp[index][tight][trend][sum][lz][li];
        }

        int ub = (tight == 1) ? num.charAt(index) - '0' : 9;
        long res = 0;
        for(int i = 0; i <=ub;i++){
            int newTight = (tight == 1 && i == ub) ? 1 : 0;
            if(lz == 0 && i == 0){
                res += solve(num,index+1,newTight,0,-1,sum,0);
                continue;
            }
            else{
                int newSum = sum + i;
                if(lz == 0){
                    res += solve(num,index+1,newTight,0,i,newSum,1);
                    continue;
                }
                int newDirection;
                if(trend == 3){
                    newDirection = 3;
                }
                else if(trend == 0){
                    if(i > prev){
                        newDirection = 1;
                    }
                    else if(i < prev){
                        newDirection = 2;
                    }
                    else {
                        newDirection = 3;
                    }
                }
                else if(trend == 1){
                    newDirection = (i > prev) ? 1 : 3;
                }
                else {
                    newDirection = (i < prev) ? 2 : 3;
                }

                res += solve(num,index+1,newTight,newDirection,i,newSum,1);

            }
        }

        return dp[index][tight][trend][sum][lz][li] = res;

    }

    private boolean good(int n) {
        String s = String.valueOf(n);
        boolean inc = true, dec = true;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) <= s.charAt(i)) {
                inc = false;
            }
            if (s.charAt(i + 1) >= s.charAt(i)) {
                dec = false;
            }
        }

        return inc || dec;
    }

}