class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int i : nums){
            maxOr = (maxOr|i);
        }

        return helper(nums,0,0,maxOr);
    }

    private int helper(int[] arr, int i, int curr, int target){
        if(i == arr.length){
            return curr == target ? 1 : 0;
        }

        return helper(arr,i+1,curr,target) + helper(arr,i+1,curr|arr[i],target);
    }
}