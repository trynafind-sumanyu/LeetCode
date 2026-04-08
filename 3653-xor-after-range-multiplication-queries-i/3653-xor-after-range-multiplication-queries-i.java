class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1_000_000_007;
        for(int[] row : queries)   {
            for(int i = row[0];i < nums.length && i<=row[1];i = i+row[2]){
                nums[i] = (int)(((long)nums[i]*row[3])%MOD);
            }
        }

        int ans = 0;
        for(int i : nums){
            ans = ans^i;
        }
        return ans;
    }
}