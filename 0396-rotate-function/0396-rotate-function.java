class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int f = 0;
        /*
            f[0] = 0*[0] + 1*[1] + 2*[2] + 3*[3]
            f[1] = 1*[0] + 2*[1] + 3*[2] + 0*[3]
            f[2] = 2*[0] + 3*[1] + 0*[2] + 1*[3]
            f[3] = 3*[0] + 0*[1] + 1*[2] + 2*[3]

            f[1] - f[0] = 1[0] + 1[1] + 1[2] - 3[3]


            f[2] - f[1] = 1[0] + 1[1] - 3[2] + 1[3] + 1[2] - 1[2] = 1[0]+1[1]+1[2]+1[3] - 4[2]
            f[k] - f[k-1] =                                               Sum of Array  - n*[n-k]


            f[k+1] = f[k] + Sum of Array - n*[n-k-1]  : k = 1 hence k+1 = 2 so 4-1-1 = 2 correct

         */
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        for(int i = 0;i<n;i++){
            //f[0]
            f += nums[i]*i;
        }

        int max = f;
        for(int i = 1;i<n;i++){
            f += sum - n*nums[n-i];
            max = Math.max(max,f);
        }
        return max;
    }
}