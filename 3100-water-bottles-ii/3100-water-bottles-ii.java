class Solution {
    public int maxBottlesDrunk(int b, int k) {
        int ans = b;

        int e = b;
        int f = 0;

        while(f > 0 || (f + e) >= k){
            if(f == 0){
                e -= k;
                k++;
                f++;
            }
            else {
                ans += f;
                e += f;
                f = 0;
            }
        }
        
        return ans;
    }
}