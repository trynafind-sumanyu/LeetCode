class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int[] nums = new int[m*n];

        int index = 0;
        for(int[] r : grid){
            for(int num : r){
                nums[index++] = num;
            }
        }

        Arrays.sort(nums);

        int target = nums[nums.length/2];

        int total = 0;

        for(int num : nums){
            int temp = Math.abs(num-target);
            if(temp % x != 0){
                return -1;
            }
            total += temp/x;
        }
        return total;
    }
}