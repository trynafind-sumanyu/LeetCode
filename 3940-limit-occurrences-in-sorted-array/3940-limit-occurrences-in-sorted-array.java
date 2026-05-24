class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[101];

        for(int i : nums){
            if(freq[i] >= k){
                continue;
            }
            else{
                freq[i]++;
            }
        }
        List<Integer> list = new ArrayList<>();

        for(int i = 0;i<101;i++){
            if(freq[i] > 0){
                list.addAll(Collections.nCopies(freq[i],i));
            }
        }

        int[] ans = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}