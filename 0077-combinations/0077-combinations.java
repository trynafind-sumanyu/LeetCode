class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> up = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            up.add(i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        helper(up, k, new ArrayList<>(),ans);
        return ans;

    }

    private void helper(List<Integer> up,int k, List<Integer> p,List<List<Integer>> ans) {
        if (p.size() == k) {
            ans.add(new ArrayList<>(p));
            return;
        }

        for(int i = 0;i<up.size();i++) {
            p.add(up.get(i));
            helper(up.subList(i+1,up.size()),k, p,ans);
            p.remove(p.size()-1);
        }
    }
}