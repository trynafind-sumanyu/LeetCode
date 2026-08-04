class Solution {

    int[][] dp = new int[2501][2501];

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        for(int[] a : dp){
            Arrays.fill(a,-1);
        }

        return solve(nums,0,-1);
    }

    int solve(int[] nums, int i, int p){
        
        int n = nums.length;

        if(i >= n){
            return 0;
        }

        if(p != -1 && dp[i][p] != -1){
            return dp[i][p];
        }

        int take = 0;
        
        if(p == -1 || nums[i] > nums[p]){
            take = 1 + solve(nums,i+1,i);
        }

        int skip = solve(nums,i+1,p);

        if(p!= -1){
            dp[i][p] = Math.max(take,skip);
        }
        return Math.max(take,skip);
    }

}