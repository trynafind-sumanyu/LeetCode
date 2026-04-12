class Solution {
    public String mergeCharacters(String s, int k) {
        List<Character> ch = new ArrayList<>();

        for(char c : s.toCharArray()){
            if(ch.size() < k){
                if(!ch.contains(c)){
                    ch.add(c);
                }
            }else{
                if(!ch.subList(ch.size()-k,ch.size()).contains(c)){
                    ch.add(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for(char c : ch){
            sb.append(c);
        }
        return sb.toString();

    }
}