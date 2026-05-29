class Solution {
    public int minElement(int[] nums) {
        for(int i =0;i<nums.length;i++){
            nums[i] = sum(nums[i]);
        }

        int min = Integer.MAX_VALUE;
        for(int i : nums){
            min = Math.min(min,i);
        }
        return min;
    }

    private int sum(int n){
        int sum = 0;
        while(n > 0){
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
}