class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        Set<Character> set = new HashSet<>();

        for(char c : word.toCharArray()){
            set.add(c);
        }
        int ans = 0;
        for(char c : set){
            if(c >= 'a' && c <= 'z'){
                if(set.contains((char)(c - 32)) && (word.lastIndexOf(c) < word.indexOf((char)(c - 32)))){
                    ans++;
                }
            }
        }
        return ans;
    }
}