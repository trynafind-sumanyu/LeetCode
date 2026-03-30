class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> list = permutation(new ArrayList<>(), Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new)));
        return new ArrayList<>(list);
    }

    static HashSet<List<Integer>> permutation(ArrayList<Integer> p, ArrayList<Integer> up) {
        HashSet<List<Integer>> list = new HashSet<>();
        if (up.isEmpty()) {
            list.add(p);
            return list;
        }

        int num = up.get(0);

        for (int i = 0; i <= p.size(); i++) {
            ArrayList<Integer> first = new ArrayList<>(p.subList(0, i));
            ArrayList<Integer> second = new ArrayList<>(p.subList(i, p.size()));
            first.add(num);
            if(!first.contains(second)){
                first.addAll(second);
            }
            list.addAll(permutation(first, new ArrayList<>(up.subList(1, up.size()))));
        }

        return list;
    }
}
