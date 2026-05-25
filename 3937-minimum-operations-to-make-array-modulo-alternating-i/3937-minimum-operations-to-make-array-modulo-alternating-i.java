class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for(int x = 0;x<k;x++){
            for(int y = 0;y<k;y++){
                if(x == y){
                    continue;
                }

                int curr = 0;
                for(int i = 0;i<n;i++){
                    int t = i%2 == 0 ? x : y;
                    int d = Math.abs((nums[i]%k)-t);
                    curr += Math.min(d,k-d);
                } 
                res = Math.min(res,curr);
            }
        }
        return res;
    }
}