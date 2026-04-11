class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int check = 0;
        if (nums[0] < nums[nums.length -1]){
            check++;
        }
        for(int i = 0;i< n-1;i++){
            if(nums[i] > nums[i+1]){
                check ++;
            }
        }
        return check <= 1;
    }
}