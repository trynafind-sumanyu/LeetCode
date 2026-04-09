class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int B = (int)Math.sqrt(n);
        int MOD = (int)1e9+7;

        ArrayList<int[]>[][] store = new ArrayList[B+1][B+1];

        for(int i = 0;i<B;i++){
            for(int j=0;j<B;j++){
                store[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0;i<m;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int k = queries[i][2];
            int v = queries[i][3];

            if ( k >= B){
                for(int j = l;j<=r;j+=k){
                    nums[j] = (int)(((long)nums[j]*v)%MOD);
                }
            }
            else{
                int rem = l % k;
                store[k][rem].add(new int[]{l, r, v});
            }
        }

        for(int k = 1;k<B;k++){
            for(int rem = 0;rem < k;rem++){
                if(store[k][rem].isEmpty()){
                    continue;
                }
                ArrayList<int[]> queryList = store[k][rem];
                int chainLength = (n-rem+k-1)/k;
                long[] diff = new long[chainLength+1];
                Arrays.fill(diff,1L);

                for(int[] q : queryList){
                    int l = q[0],r = q[1], v = q[2];

                    int startPos = (l-rem)/k;
                    int endPos = (r-rem)/k;

                    if(startPos < 0){
                        startPos = 0;
                    }
                    if(endPos >= chainLength){
                        endPos = chainLength-1;
                    }
                    if(startPos > endPos){
                        continue;
                    }

                    diff[startPos] = (diff[startPos]*v)%MOD;
                    if(endPos < chainLength - 1){
                        diff[endPos+1] = (diff[endPos+1]*modInv(v,MOD))%MOD; 
                    }
                }
                long curr = 1L;
                for(int pos = 0;pos<chainLength;pos++){
                    curr = (curr*diff[pos])%MOD;
                    int idx = rem + pos*k;
                    nums[idx] = (int)(((long)nums[idx]*curr)%MOD);
                }
            }
        }

        int res = 0;
        for(int i : nums){
            res ^= i;
        }
        return res;
    }

    private long modInv(long n, int MOD){
        return pow(n,(long)MOD-2,MOD);
    }

    private long pow(long a, long b, int MOD){
        long ans = 1;
        while(b > 0){
            if((b&1) == 1){
                ans = (ans*a)%MOD;
            }
            a = (a*a)%MOD;
            b >>= 1;
        }
        return ans;
    }
}