class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] ans = new int[q];

        int[] closest = new int[n];
        closest[0] = 1;
        closest[n-1] = n-2;

        for(int i = 1;i<n-1;i++){
            int l = Math.abs(nums[i]-nums[i-1]);
            int r = Math.abs(nums[i]-nums[i+1]);

            if(l > r){
                closest[i] = i+1;
            }
            else{
                closest[i] = i-1;
            }
        }

        long[] preRight = new long[n];
        long[] preLeft = new long[n];

        for(int i = 1;i<n;i++){
            long step = (closest[i-1] == i) ? 1 : Math.abs(nums[i-1]-nums[i]);
            preRight[i] = preRight[i-1]+step;
        }

        for(int i = n-2;i>=0;i--){
            long step = (closest[i+1] == i)? 1: Math.abs(nums[i+1]-nums[i]);
            preLeft[i] = preLeft[i+1]+step;
        }

        for(int i = 0;i<q;i++){
            int from = queries[i][0];
            int to = queries[i][1];

            if(from <=to){
                ans[i] = (int)(preRight[to] - preRight[from]);
            }
            else{
                ans[i] = (int)(preLeft[to] - preLeft[from]);
            }

        }
        return ans;
    }
}