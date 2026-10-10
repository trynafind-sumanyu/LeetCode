class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        int[] diff = new int[100001];
        long k = k1+k2; //does not matter whether nums1 elements is increased or nums2 elements decreased just close the gap, Hint 1.  
        long sum = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            int x = Math.abs(nums1[i]-nums2[i]);
            sum+=x;
            diff[x]++;
            max = Math.max(max,x);
        }
        
        // if enough moves return 0;
        if(sum <= k){
            return 0;
        }

        //if not then decrease the gap;
        for(int i = max ; i > 0 && k > 0; i--){
            long move = Math.min(k,(long)diff[i]);
            diff[i] -= move; // for each diff subtract maximum possible gaps, 
            diff[i-1] += move; // and for each gap removed (by only 1 as we can only +-1 to each element), we add that much moves to its previous value;
            k -= move; // removing those moves performed from k(total moves);
        }

        //return the square;
        long ans = 0;
        for(int i = 0;i<=max ;i++){
            ans += (long)i*i*diff[i]; //for each gap diff square * number of such gaps;
        }

        return ans;

    }   
}

/*

    3 4 4 5 6 --> k = 5
*/