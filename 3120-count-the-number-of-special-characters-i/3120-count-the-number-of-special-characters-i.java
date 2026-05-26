class Solution {
    public int numberOfSpecialChars(String word) {
        int ans =0;
        Set<Character> set = new HashSet<>();

        for(char c : word.toCharArray()){
            set.add(c);
        }


        for(char c : set){
            if(c >= 'A' && c <= 'Z'){
                char ch = (char)(c + 32);
                if(word.contains(ch+"")){
                    ans++;
                }
            }
        }
        return ans;
    }
}