class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else if (!stack.isEmpty() && c == ')'){
                stack.pop();
            }
            else {
                ans++;
            }
        }
        while(!stack.isEmpty()){
            ans++;
            stack.pop();
        }
        return ans;
    }
}