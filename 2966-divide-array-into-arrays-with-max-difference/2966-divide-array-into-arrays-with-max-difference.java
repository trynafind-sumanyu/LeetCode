class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;

        int[][] ans = new int[n/3][3];

        Arrays.sort(nums);

        for(int i = 0;i<n/3;i++){
            int a = nums[i*3];
            int b = nums[i*3+1];
            int c = nums[i*3+2];
            if((b - a > k) || (c - a > k || (c-b>k))){
                return new int[][]{};
            }

            ans[i][0] = a;
            ans[i][1] = b;
            ans[i][2] = c;
        }

        return ans;
    }
}