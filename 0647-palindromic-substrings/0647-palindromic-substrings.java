class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            for(int j = 1+i;j<=n;j++){
                StringBuilder sb = new StringBuilder(s.substring(i,j));
                StringBuilder rev = new StringBuilder(sb);
                sb.reverse();
                if(sb.compareTo(rev)==0){
                    ans++;
                }
            }
        }
        return ans;
    }
}