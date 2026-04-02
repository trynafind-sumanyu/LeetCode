class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] nums, int target, List<Integer> p, List<List<Integer>> ans) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(p);
            Collections.sort(temp);
            if (!ans.contains(temp)) {
                ans.add(temp);
            }
            return;
        }

        for (int num : nums) {
            if (num > target) {
                break;
            }

            p.add(num);
            helper(nums, target - num, p, ans);
            p.remove(p.size() - 1);
        }
    }
}