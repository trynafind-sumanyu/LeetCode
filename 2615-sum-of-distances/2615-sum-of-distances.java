class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        long[] ans = new long[n];
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            List<Integer> list = entry.getValue();
            long[] a =getSumAbsoluteDifferences(list);
            for(int i = 0;i<list.size();i++){
                ans[list.get(i)] = a[i];
            }
        }
        return ans;
    }

    public long[] getSumAbsoluteDifferences(List<Integer> list) {
        int n = list.size();
        long[][] preSuf = new long[n][2];
        for(long[] arr : preSuf){
            Arrays.fill(arr,0);
        }
        long pre = 0;
        for(int i = 0;i<n;i++){
            pre += list.get(i);
            preSuf[i][0] = pre;
        }
        long suf = 0;
        for(int i = n-1;i>=0;i--){
            suf += list.get(i);
            preSuf[i][1] = suf;
        }
        long[] ans = new long[n];

        for(int i = 0;i<n;i++){
            long a = (long) list.get(i) *(i+1);
            long b = preSuf[i][0];
            long c = preSuf[i][1];
            long d = (long) list.get(i) *(n-i);
            ans[i] = a-b + c-d;
        }
        return ans;
    }
}