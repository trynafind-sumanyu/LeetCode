class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 10;
        }
        int num = (int)Math.pow(10,n);

        return num - numDupDigitsAtMostN(num) + 1;
    }

    int[][][][][] dp = new int[10][2][2][1023][2];
    public int numDupDigitsAtMostN(int n) {
        String num = String.valueOf(n);
        for(int[][][][] x : dp){
            for(int[][][] y : x){
                for(int[][] z : y){
                    for(int[] a : z){
                       Arrays.fill(a, -1);
                    }
                }
            }
        }
        return solve(num,0,1,0,0,1,false);
    }

    private int solve(String num,int index, int tight, int rep,int mask,int lz, boolean isUsed){
        if(index == num.length()){
            return rep;
        }

        if(dp[index][tight][rep][mask][lz] != -1){
            return dp[index][tight][rep][mask][lz];
        }

        int lb = 0;
        int ub = (tight == 1) ? num.charAt(index) - '0' : 9;
        int res = 0;
        for(int dig = lb; dig <= ub; dig++){
            int newTight = (tight == 1 && dig == ub) ? 1 : 0;
            if(lz==1 && dig == 0){
                res += solve(num,index+1,newTight,0,0,1,false);
            }
            else {
                boolean isUsedNew = (1 & (mask >> dig)) == 1;
                int newRep = (rep == 1 || isUsedNew) ? 1 : 0;
                res += solve(num,index+1,newTight,newRep,(mask| 1 << dig),0,isUsedNew);
            }
        }
        return dp[index][tight][rep][mask][lz] = res;
    }
}