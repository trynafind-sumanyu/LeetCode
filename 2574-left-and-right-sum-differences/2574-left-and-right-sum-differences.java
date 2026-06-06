class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[][] sum = new int[n][2];
        int left = 0;
        int right = 0;
        for(int i = 0;i<n-1;i++ ){
            left += nums[i];
            sum[i+1][0] = left;
            right += nums[n-1-i];
            sum[n-2-i][1] = right;
        }

        int[] ans = new int[n];

        for(int i = 0;i<n;i++){
            ans[i] = Math.abs(sum[i][0]-sum[i][1]);
        }
        return ans;

    }
}