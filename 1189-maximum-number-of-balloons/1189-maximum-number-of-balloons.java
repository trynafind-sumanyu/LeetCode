class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : text.toCharArray()){
            if(c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n'){
                map.put(c,map.getOrDefault(c,0)+1);
            }
        }

        if(map.size() < 5){
            return 0;
        }

        int b = map.get('b');
        int a = map.get('a');
        int l = map.get('l');
        int o = map.get('o');
        int n = map.get('n');
        int ans = 0;
        while ( b > 0 && a > 0 && n > 0 && l > 1 && o > 1){
            ans++;
            b--;
            a--;
            n--;
            l -= 2;
            o -= 2;
        }
        return ans;
    }
}