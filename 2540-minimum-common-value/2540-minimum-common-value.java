class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        for(int i : nums1){
            if(bs(nums2,i)){
                return i;
            }
        }
        return -1;
    }

    private boolean bs(int[] nums, int target){
        int s = 0;
        int e = nums.length-1;

        while(s <=e){
            int mid = s + (e-s)/2;

            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] > target){
                e = mid-1;
            }
            else{
                s = mid + 1;
            }
        }
        return false;
    }
}