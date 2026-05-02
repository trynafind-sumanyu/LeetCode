class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int len = 0;

        boolean odd = false;

        for (int val : freq.values()) {
            if(val%2 == 1){
                odd = true;
            }
            len += val - val%2;
        }
        if(odd){
            len++;
        }
        return len;
    }
}