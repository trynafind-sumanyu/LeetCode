class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        int preSum = 0;

        for(int i=0;i<nums.length;i++){
            int sumRight = sum-nums[i]-preSum;
            if(preSum == sumRight){
                return i;
            }
            preSum += nums[i];
        }
        return -1;
    }
}