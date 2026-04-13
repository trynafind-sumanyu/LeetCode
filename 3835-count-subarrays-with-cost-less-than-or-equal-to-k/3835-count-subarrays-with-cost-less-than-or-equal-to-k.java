class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int n = nums.length;
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        int l = 0;

        for (int r = 0; r < n; r++) {
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[r]) {
                max.pollLast();
            }
            while (!min.isEmpty() && nums[min.peekLast()] >= nums[r]) {
                min.pollLast();
            }
            max.addLast(r);
            min.addLast(r);

            while (l<=r && cost(nums,max.peekFirst(),min.peekFirst(),l,r) > k) {
                if (max.peekFirst() == l) {
                    max.pollFirst();
                }
                if (min.peekFirst() == l) {
                    min.pollFirst();
                }
                l++;
            }
            ans += (r - l + 1);
        }

        return ans;
    }

    private long cost(int[] nums, int max, int min, int l, int r) {
        return (long)(nums[max] - nums[min]) *(r - l + 1);
    }
}