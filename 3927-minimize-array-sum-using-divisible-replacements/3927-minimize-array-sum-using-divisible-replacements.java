class Solution {
    public long minArraySum(int[] nums) {
    
        Arrays.sort(nums);
        int max = nums[nums.length - 1];

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.merge(x, 1, Integer::sum);

        boolean[] visited = new boolean[max + 1];
        long sum = 0;

        for (int i : nums) {
            if (!visited[i]) {
                for (int j = i; j <= max; j += i) {
                    visited[j] = true;
                    if (freq.containsKey(j)) {
                        sum += (long) i * freq.get(j);
                        freq.remove(j);
                    }
                }
            }
        }
        return sum;
    }
}