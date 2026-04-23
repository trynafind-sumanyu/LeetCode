class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            if(nums[i]-1!= i){
                ans.add(nums[i]);
            }
        }
        return ans;
    }

    // Sort the array
    void sort(int[] nums){
        int i = 0;
        while(i<nums.length){
            int correct = nums[i]-1;
            if(nums[correct]!=nums[i]){
                swap(nums,i,correct);
            }else {
                i++;
            }
        }
    }
    // Swap the element with correct index
    void swap(int[] nums,int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}