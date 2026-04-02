class Solution {
    HashMap<String, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty()){
            return ans;
        }
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");

        ans.addAll(combine("", digits));
        return ans;
        
    }

    private List<String> combine(String p, String up){
        List<String> list = new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }

        char c = up.charAt(0);

        for(int i = 0;i<map.get(Character.toString(c)).length();i++){
            list.addAll(combine(p + (map.get(Character.toString(c)).charAt(i)), up.substring(1)));
        }
        return list;
    }
}