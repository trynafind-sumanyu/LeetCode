class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();

        Stack<Integer> st = new Stack<>();

        for(int i : nums){
            while(i > 0){
                st.push(i%10);
                i /= 10;
            }
            while(!st.isEmpty()){
                list.add(st.pop());
            }
        }
        int[] ans = new int[list.size()];
        for(int i =0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}