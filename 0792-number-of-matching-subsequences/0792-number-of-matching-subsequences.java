class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int ans = 0;
        for(String st : words){
            map.put(st,map.getOrDefault(st,0)+1);
        }
        
        for(String str : map.keySet()){
            if(isSubsequence(str,s)){
                ans+=map.get(str);
            }
        }
        return ans;
    }

    boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}