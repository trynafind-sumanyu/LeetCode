class Solution {
    public int longestCommonPrefix(int[] A, int[] B) {
        
        int n = A.length;

        Set<Integer> prefix = new HashSet<>();

        for(int i : A){
            int num = i;
            while(num > 0){
                prefix.add(num);
                num/= 10;
            }
        }
        int max = 0;
        for(int i : B){
            int j = i;
            int cur = 0;
            while(j > 0){
                if(prefix.contains(j)){
                    cur = (int)Math.log10(j)+1;
                    break;
                }
                j /= 10;
            }
            max = Math.max(max,cur);
        }
        return max;
    }
}