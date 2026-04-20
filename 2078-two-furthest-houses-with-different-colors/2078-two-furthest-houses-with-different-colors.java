class Solution {
    public int maxDistance(int[] h) {
        int s = 0;
        int e = h.length-1;
        int left = 0;
        int right = 0;
        for(int i = 0;i<h.length;i++){
            if(h[e] != h[i]){
                left = Math.max(left,Math.abs(e-i));
            }
        }

        for(int i = e;i>=0;i--){
            if(h[i] != h[s]){
                right = Math.max(right,Math.abs(i-s));
            }
        }

        return Math.max(right,left);
    }
}