class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = n-1;i>=0;i--){
            int rev = rev(nums[i]);
            if(rev == nums[i]){
                if(map.containsKey(rev)){
                    if(map.get(rev(nums[i])) != i){
                        ans = Math.min(ans,Math.abs(i-map.get(rev)));
                    }
                }
            }
            map.put(nums[i],i);
            if(map.containsKey(rev)){
                if(map.get(rev(nums[i])) != i){
                    ans = Math.min(ans,Math.abs(i-map.get(rev)));
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;


    }

    private int rev(int n) {
        int ans = 0;
        while (n > 0) {
            ans = ans * 10 + n % 10;
            n /= 10;
        }
        return ans;
    }
}