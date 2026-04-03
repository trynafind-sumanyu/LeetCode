class Solution {
    //Non - Decreasing Subsequences
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        helperFindSubsequences(nums, ans, new ArrayList<>(), 0);
        return new ArrayList<>(ans);
    }

    private void helperFindSubsequences(int[] nums, HashSet<List<Integer>> ans, List<Integer> p, int index) {
        if (index == nums.length) {
            if (p.size() > 1) {
                List<Integer> temp = new ArrayList<>(p);
                ans.add(temp);
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (!p.isEmpty() && nums[index] < p.get(p.size()-1)) {
                continue;
            }
            p.add(nums[index]);
            helperFindSubsequences(nums, ans, p, i + 1);
            p.remove(p.size() - 1);
            helperFindSubsequences(nums, ans, p, i + 1);
        }
    }
}