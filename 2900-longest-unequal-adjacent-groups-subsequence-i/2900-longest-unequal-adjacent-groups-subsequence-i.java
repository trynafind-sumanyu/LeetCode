class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int last = -1;
        int n = words.length;
        List<String> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(last != groups[i]){
                ans.add(words[i]);
                last = groups[i];                
            }
        }
        return ans;
    }
}