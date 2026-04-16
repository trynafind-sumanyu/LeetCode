class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int n = nums.length;
        int q = queries.length;
        for(int i = 0;i<n;i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i : queries){
            int num = nums[i];
            List<Integer> list = map.get(num);
            if(list.size() < 2){
                ans.add(-1);
            }
            else {
                int index = Collections.binarySearch(list,i);
                int left = 0;
                int right = 0;
                if(index == 0){
                    left = list.get(index+1)-list.getFirst();
                    right = list.get(index)+(n-list.getLast());
                }
                else if(index == list.size()-1){
                    right = n-list.getLast()+list.getFirst();
                    left = list.get(index) - list.get(index-1);
                }
                else{
                    right = list.get(index+1) - list.get(index);
                    left = list.get(index) - list.get(index-1);
                }
                ans.add(Math.min(left,right));
            }
        }
        return ans;
    }
}