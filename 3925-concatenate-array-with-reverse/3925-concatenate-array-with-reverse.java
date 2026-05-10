class Solution {
    public int[] concatWithReverse(int[] nums) {
        int[] ans = new int[2*nums.length];

        for(int i = 0;i<nums.length;i++){
            ans[i] = nums[i];
        }
        int index = nums.length;
        for(int i = nums.length-1;i>=0;i--){
            ans[index++] = nums[i];
        }
        return ans;
    }
}