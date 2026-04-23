class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[][] preSuf = new int[n][2];
        for(int[] arr : preSuf){
            Arrays.fill(arr,0);
        }
        int pre = 0;
        for(int i = 0;i<n;i++){
            pre += nums[i];
            preSuf[i][0] = pre;
        }
        int suf = 0;
        for(int i = n-1;i>=0;i--){
            suf += nums[i];
            preSuf[i][1] = suf;
        }
        int[] ans = new int[n];

        for(int i = 0;i<n;i++){
            int a = nums[i]*(i+1);
            int b = preSuf[i][0];
            int c = preSuf[i][1];
            int d = nums[i]*(n-i);
            ans[i] = a-b + c-d;
        }
        return ans;
    }
}