class Solution {
    public long minOperations(int[] nums) {
        long ans = 0;
        for(int i = 0;i+1<nums.length;i++){
            ans += Math.max(0,nums[i]-nums[i+1]);
        }
        return ans;
    }
}