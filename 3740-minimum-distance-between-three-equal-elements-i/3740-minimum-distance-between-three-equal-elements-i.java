class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        List<Integer>[] list = new List[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            list[nums[i]].add(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>(list[nums[i]]);
            if (l.size() >= 3) {
                for (int j = 0; j < l.size() - 2; j++) {
                    int a = l.get(j);
                    int b = l.get(j + 1);
                    int c = l.get(j + 2);
                    int val = Math.abs(a - b) + Math.abs(b - c) + Math.abs(c - a);
                    ans = Math.min(ans, val);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}