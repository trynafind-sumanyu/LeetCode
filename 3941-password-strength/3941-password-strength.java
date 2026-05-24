class Solution {
    public int passwordStrength(String password) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(char c : password.toCharArray()){
            if(set.contains(c)){
                continue;
            }
            else{
                set.add(c);
                if(c >= 'a' && c <= 'z'){
                    res += 1;
                }
                else if(c >= 'A' && c <= 'Z'){
                    res += 2;
                }
                else if(c >= '0' && c <= '9'){
                    res += 3;
                }
                else {
                    res += 5;
                }
            }

        }
        return res;
    }
}