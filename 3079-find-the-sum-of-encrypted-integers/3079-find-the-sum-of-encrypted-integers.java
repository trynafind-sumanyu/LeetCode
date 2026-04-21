class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            int max = max(nums[i]);
            StringBuilder num = new StringBuilder();
            while(nums[i] > 0){
                num.append(max);
                nums[i] /= 10;
            }
            sum += Integer.parseInt(num.toString());
        }
        return sum;
    }


    private int max(int n){
        int max = 0;
        while(n > 0){
            max = Math.max(n%10,max);
            n /= 10;
        }
        return max;
    }
}