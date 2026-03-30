class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder up = new StringBuilder();
        up.append("(".repeat(Math.max(0, n)));
        up.append(")".repeat(Math.max(0, n)));

        return new ArrayList<>(helper(n, 0, 0, new StringBuilder()));
    }

    private List<String> helper(int n,int open,int closed,StringBuilder p){
        List<String> list = new ArrayList<>();
        if(p.length() == n*2){
            list.add(p.toString());
            return list;
        }

        if(open == n){
            p.append(")");
            list.addAll(helper(n,open,closed+1,p));
            p.deleteCharAt(p.length()-1);
            return list;
        }

        else{
            list.addAll(helper(n,open+1,closed,p.append("(")));
            p.deleteCharAt(p.length()-1);
            if(open > closed){
                list.addAll(helper(n,open,closed+1,p.append(")")));
                p.deleteCharAt(p.length()-1);
            }
        }
        return list;
    }
}