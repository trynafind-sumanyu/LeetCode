class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper2(candidates, target, new ArrayList<>(), ans, 0);
        return ans;
    }

    private void helper2(int[] nums, int target, List<Integer> p, List<List<Integer>> ans, int index) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(p);
            ans.add(temp);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > target) {
                break;
            }

            p.add(nums[i]);
            helper2(nums, target - nums[i], p, ans, i + 1);
            p.remove(p.size() - 1);
        }

    }
}