class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        for (String w : queries){
            for(String d : dictionary){
                int diff = 0;
                if(w.length() != d.length()){
                    continue;
                }
                else{
                    for(int i = 0;i<w.length();i++){
                        if(diff > 2){
                            break;
                        }
                        if(w.charAt(i) != d.charAt(i)){
                            diff++;
                        }
                    }
                }
                if (diff < 3){
                    ans.add(w);
                    break;
                }
            }
        }
        return ans;
    }
}