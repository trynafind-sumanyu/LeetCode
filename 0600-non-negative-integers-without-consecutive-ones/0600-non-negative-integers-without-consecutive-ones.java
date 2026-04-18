class Solution {

    int[][][] dp = new int[30][2][2];
    public int findIntegers(int n) {
        String num = Integer.toBinaryString(n);
        for(int[][] z : dp) {
            for (int[] x : z) {
                Arrays.fill(x, -1);
            }
        }
        return solve(num,1,0,0);
    }

    private int solve(String num,int tight,int index,int prev){
        if(index == num.length()){
            return 1;
        }

        if(dp[index][tight][prev] != -1){
            return dp[index][tight][prev];
        }

        int lb = 0;
        int ub = (tight == 1) ? num.charAt(index) - '0' : 1;
        int res = 0;
        for(int i = lb;i<=ub;i++){
            int newTight = (tight == 1 && i == ub) ? 1 : 0;

            if(prev == 1 && i == 1){
                continue;
            }
            res += solve(num,newTight,index+1,(i == 1) ? 1 : 0);
        }
        return dp[index][tight][prev] = res;
    }
}