class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int ascii = 97;
        HashMap<Integer, Character> map = new HashMap<>();

        for (int i = 0; i <26; i++) {
            map.put(i, (char) ('z' - i));
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            int sum = 0;
            for (int j = 0; j < words[i].length(); j++) {
                sum += weights[(int) (words[i].charAt(j)) - 97];
            }
            ans.append(map.get(sum%26));

        }

        return ans.toString();


    }
}