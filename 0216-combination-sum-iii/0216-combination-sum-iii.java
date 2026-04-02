class Solution {
    //Combination sum 3
    public List<List<Integer>> combinationSum3(int k, int n) {
        return helper3(k, n, new ArrayList<>(), 1);
    }

    private List<List<Integer>> helper3(int k, int target, List<Integer> p, int index) {
        List<List<Integer>> ans = new ArrayList<>();
        if (target == 0) {
            if (p.size() == k) {
                List<Integer> temp = new ArrayList<>(p);
                ans.add(temp);
            }
            return ans;
        }

        for (int i = index; i <= 9; i++) {
            if (i > target) {
                break;
            }
            p.add(i);
            ans.addAll(helper3(k, target - i, p, i + 1));
            p.remove(p.size() - 1);
        }
        return ans;
    }
}