class Solution {
    static int[] dp = new int[1000];

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;

        Arrays.fill(dp, Integer.MIN_VALUE);

        int ans = dfs(0, nums, target, dp);

        return ans < 0 ? -1 : ans;

    }

    private int dfs(int i, int[] nums, int target, int[] dp) {
        if (i == nums.length - 1) {
            return 0;
        }

        if (dp[i] != Integer.MIN_VALUE) {
            return dp[i];
        }

        int ans = Integer.MIN_VALUE;

        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[i] - nums[j]) <= target) {
                ans = Math.max(ans, dfs(j, nums, target, dp) + 1);
            }
        }
        return dp[i] = ans;
    }
}