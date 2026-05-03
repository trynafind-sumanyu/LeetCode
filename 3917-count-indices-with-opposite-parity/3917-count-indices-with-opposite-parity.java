class Solution {
    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        for(int i = 0;i<n;i++){
            boolean even = false;
            boolean odd = false;
            if (nums[i]%2 == 0){
                even = true;
            }
            else {
                odd = true;
            }
            int parity = 0;
            for(int j = i+1;j<n;j++){
                if(even){
                    if(nums[j]%2 == 1){
                        parity++;
                    }
                }
                else{
                    if(nums[j]%2 == 0){
                        parity++;
                    }
                }
            }
            ans[i] = parity;
        }
        return ans;
    }
}