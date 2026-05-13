class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2*limit + 2];
        
        for(int i = 0;i < n/2;i++){

            int a = nums[i];
            int b = nums[n-1-i];

            int minVal = Math.min(a,b) + 1;
            int maxVal = Math.max(a,b) + limit;

            diff[2] += 2;
            diff[2*limit + 1] -= 2;

            //For 1 move;
            diff[minVal] += -1;
            diff[maxVal+1] -= -1;

            //For 0 move --> [a,b] to [a,b]
            diff[a+b] += -1;
            diff[a+b+1] -= -1;
        }

        int ans = Integer.MAX_VALUE;
        for(int sum = 2;sum <= 2*limit; sum++){
            diff[sum] += diff[sum-1];
            ans = Math.min(ans,diff[sum]);
        }
        return ans;
    }
}