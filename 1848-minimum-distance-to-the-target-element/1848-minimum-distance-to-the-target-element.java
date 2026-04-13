class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int l = start;
        int r = start;
        boolean foundL = false;
        boolean foundR = false;

        while(l >=0){
            if(nums[l] == target){
                foundL = true;
                break;
            }
            l--;
        }

        while(r<nums.length){
            if(nums[r] == target){
                foundR = true;
                break;
            }
            r++;
        }
        

        if(foundL && foundR){
            return Math.min(Math.abs(l-start),Math.abs(r-start));
        }
        else{
            if(foundR){
                return Math.abs(r-start);
            }
            else{
                return Math.abs(l-start);
            }
        }
    }
}