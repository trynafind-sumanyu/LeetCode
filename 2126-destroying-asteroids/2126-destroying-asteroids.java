class Solution {
    public boolean asteroidsDestroyed(int mass, int[] a) {
        Arrays.sort(a);
        long m = mass;
        for(int i : a){
            if(m < i ){
                return false;
            }
            m += i;
        }
        return true;
    }
}