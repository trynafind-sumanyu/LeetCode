class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        boolean closedPrev = false;
        for(char c : s.toCharArray()){
            if(c == '('){
                if(!closedPrev) {
                    stack.push(c);
                }
                else {
                    if(stack.isEmpty()){
                        stack.push(c);
                        ans+=2;
                    }else{
                        ans++;

                    }
                    closedPrev = false;
                }
            }
            else if(!stack.isEmpty() && closedPrev && c == ')'){
                stack.pop();
                closedPrev = false;
            }
            else if(!stack.isEmpty() && !closedPrev && c == ')'){
                closedPrev = true;
            }
            else if(stack.isEmpty() && closedPrev){
                ans++;
                closedPrev = false;
            }
            else if(stack.isEmpty() && !closedPrev){
                closedPrev = true;
            }
        }
        while(!stack.isEmpty()){
            if(closedPrev){
                ans++;
                closedPrev = false;
            }
            else {
                ans += 2;
            }
            stack.pop();
        }

        if(closedPrev){
            ans += 2;
        }
        return ans;
    }
}