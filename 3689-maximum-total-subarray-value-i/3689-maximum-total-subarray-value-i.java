class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for(int i : nums){
            max = Math.max(i,max);
            min = Math.min(i,min);
        } 

        long ans = max*k - min*k;
        return ans;
    }
}