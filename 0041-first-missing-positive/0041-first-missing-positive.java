class Solution {
    public int firstMissingPositive(int[] nums) {
        sort(nums);
        for (int i = 0;i<nums.length;i++){
            if (nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }

    //Sorting array
    void sort(int[] nums){
        int i = 0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if (correct<0 || correct>=nums.length){
                i++;
            }
            else if(nums[correct]!=nums[i]){
                swap(nums,i,correct);
            }else {
                i++;
            }
        }
    }

    // Swapping the correct indexes
    void swap(int[] nums,int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}