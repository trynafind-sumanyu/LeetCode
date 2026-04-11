class Solution {
    public int removeDuplicates(int[] nums) {
        int[] ans = new int[nums.length];
        int k =0;
        for (int i=0;i<nums.length;i++){
            if(i<nums.length-1&&nums[i]==nums[i+1]){
                continue;
            }else {
                ans[k]=nums[i];
                k++;
            }
        }
        for(int j = 0;j<nums.length;j++){
            nums[j]=ans[j];
        }

        return k;
    }
    
}