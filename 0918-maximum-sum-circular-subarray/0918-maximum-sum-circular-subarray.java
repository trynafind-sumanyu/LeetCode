class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int total = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        int currMin = 0;
        for(int i : nums){
            total += i;

            currMin += i;
            currMax += i;

            min = Math.min(min,currMin);
            max = Math.max(max,currMax);

            if(currMax < 0){
                currMax = 0;
            }
            if(currMin > 0){
                currMin = 0;
            }
        }

        return max > 0 ? Math.max(total - min,max) : max;
    }
}