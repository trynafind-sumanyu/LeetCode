class Solution {
    
    public int mirrorFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        }

        int ans = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char mirror =(char)(122+(int)'a'-ch);
            if (ch <= mirror) {
                ans += Math.abs(map.getOrDefault(ch, 0) - map.getOrDefault(mirror, 0));
            }
        }

        for (char ch = '0'; ch <= '9'; ch++) {
            char mirror = (char) ('0' + 9 - (ch - '0'));
            if (ch <= mirror) {
                ans += Math.abs(map.getOrDefault(ch, 0) - map.getOrDefault(mirror, 0));
            }
        }
        return ans;
    }



    // a = 97 z = 123 -> a+z = 220
    // b = 98 y = 122 -> 220
}