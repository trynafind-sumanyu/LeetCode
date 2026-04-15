class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int ans = 0;      
        boolean[] empty = new boolean[n];
        Arrays.fill(empty,true);

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(baskets[j] >= fruits[i] && empty[j]){
                    empty[j] = false;
                    ans++;
                    break;
                }
            }
        }
        return n-ans;


    }
}