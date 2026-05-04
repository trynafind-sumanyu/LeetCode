class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(String s : operations){
            switch (s) {
                case "C" -> st.pop();
                case "D" -> st.push(st.peek() * 2);
                case "+" -> {
                    int a = st.pop();
                    int b = st.pop();
                    st.push(b);
                    st.push(a);
                    st.push(a + b);
                }
                default -> st.push(Integer.parseInt(s));
            }
        }

        int ans = 0;

        while(!st.isEmpty()){
            ans += st.pop();
        }
        return ans;
    }
}