class Solution {
    public int minimumSwaps(int[] nums) {
        int z = 0;

        for(int i : nums){
            if(i == 0){
                z++;
            }
        }

        int an = 0;
        int n = nums.length-1;
        while(z > 0){
            if(nums[n--] != 0){
                an++;
            }
            z--;
        }
        return an;
    }
}