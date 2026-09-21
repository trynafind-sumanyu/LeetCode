class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;

        long[] result = new long[k];
        long[] prevCount = new long[k];

        for(int i = 0;i<n;i++){
            //index i par end hone wale sare sub-arrays
            int[] currCount = new int[k];

            int currElemRem = nums[i]%k; //Current element ka remainder
            currCount[currElemRem]++;

            for(int oldRem = 0;oldRem < k;oldRem++){
                int newRem = (int)((long)oldRem * nums[i] % k) % k;

                currCount[newRem] += prevCount[oldRem];
            } 

            for(int x = 0;x<k;x++){
                prevCount[x] = currCount[x];
            }

            for(int x = 0;x<k;x++){
                result[x] += prevCount[x];
            }   
        }

        return result;

    }
}