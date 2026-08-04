class Solution {
    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                long Gc = (long)gcd(nums[i],nums[j]);
                Gc = Gc*Gc;
                long str = ((long)nums[i]*nums[j])/Gc;

                max = Math.max(str,max);
            }
        }
        return max;
    }

    private int gcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}