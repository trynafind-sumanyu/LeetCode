class Solution {
    public boolean isGood(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();

        if (nums.length != max+1){
            return false;
        }

        sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(i == nums.length-1){
                return nums[i] == i;
            }
            if(nums[i] != i+1){
                return false;
            }
        }
        return true;
    }

    private void sort(int[] nums){
        //swap nums[i] with nums[nums[i]];
        // 1--> 0
        // 

        int i = 0;
        while(i < nums.length){
            int correct = nums[i]-1;

            if(correct < 0 || correct >= nums.length){
                i++;
            }
            else if(nums[correct] != nums[i]){
                swap(nums,correct,i);
            }
            else{
                i++;
            }
        }
        
    }

    private void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}