class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;

        List<Integer> num = new ArrayList<>();
        for(int i : nums){
            num.add(i);
        }
        for(int i = 1; i < 101; i++){
            if(!num.contains(k*i)){
                return k*i;
            }
        }
        return k*101;
    }
}