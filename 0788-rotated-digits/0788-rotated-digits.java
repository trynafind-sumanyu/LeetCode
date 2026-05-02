class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        for(int i = 1;i<=n;i++){
            boolean twoFiveSixNine = false;
            boolean threeFourSeven = false;
            int num = i;
            while(num > 0){
                int rem = num%10;
                if(rem == 3 || rem == 4 || rem == 7){
                    threeFourSeven = true;
                    break;
                }

                if(rem == 2 || rem == 5 || rem == 6 || rem == 9){
                    twoFiveSixNine = true;
                }
                num /= 10;
            }
            if(threeFourSeven){
                continue;
            }
            if(twoFiveSixNine){
                ans++;
            }
        }
        return ans;
    }
}