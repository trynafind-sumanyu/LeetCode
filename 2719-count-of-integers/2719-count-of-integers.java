class Solution {
    int[][][] p = new int[23][2][200];
    static final int MOD = (int)1e9+7;
    public int count(String num1, String num2, int min_sum, int max_sum) {
        String l = subtractOne(num1);
        String r = num2;

        for(int[][] x : p){
            for(int[] y : x){
                Arrays.fill(y, -1);
            }
        }
        int ansR = (solve(num2,min_sum,max_sum))%MOD;
        for(int[][] x : p){
            for(int[] y : x){
                Arrays.fill(y, -1);
            }
        }
        int ansL = (solve(l,min_sum,max_sum))%MOD;
        return  (ansR - ansL+MOD)%MOD;
    }

    private int solve(String num,int min,int max){
        return (helper(num,0,1,max,min,0))%MOD;
    }

    private String subtractOne(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int i = n - 1;

        while (i >= 0) {
            if (sb.charAt(i) > '0') {
                sb.setCharAt(i, (char)(sb.charAt(i) - 1));
                break;
            } else {
                sb.setCharAt(i, '9');
                i--;
            }
        }

        // Remove leading zero if present
        if (sb.charAt(0) == '0' && sb.length() > 1) {
            return sb.substring(1);
        }

        return sb.toString();
    }

    private int helper(String num,int index,int tight,int maxSum,int minSum,int currSum){
        if(index == num.length()){
            if(currSum >= minSum && currSum <= maxSum){
                return 1;
            }
            return 0;
        }

        if(p[index][tight][currSum] != -1){
            return p[index][tight][currSum]%MOD;
        }

        int lb = 0;
        int ub = (tight == 1) ? num.charAt(index)-'0' : 9;
        int res = 0;
        for(int dig = lb;dig<=ub;dig++){
            //invalid if currSum > Max or currSum < minSum
            if(dig+currSum > maxSum){
                continue;
            }
            int newTight = (tight == 1 && dig == ub) ? 1 : 0;
            res = (res + helper(num, index+1, newTight, maxSum, minSum, dig+currSum) % MOD) % MOD;
        }
        return p[index][tight][currSum] = res;
    }
}