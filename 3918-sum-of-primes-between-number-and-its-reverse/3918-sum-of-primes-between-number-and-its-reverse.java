class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev = rev(n);

        int min = Math.min(rev,n);
        int max = Math.max(rev,n);

        int ans = 0;
        for(int i = min;i<=max;i++){
            if(isPrime(i)){
                ans+=i;
            }
        }
        return ans;        
    }
    private boolean isPrime(int n){

        if(n == 0 || n == 1){
            return false;
        }

        for(int i = 2;i*i<=n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    private int rev(int n){
        int r = 0;
        while(n > 0){
            int rem = n%10;
            r = r*10 + rem;
            n /= 10;
        }
        return r;
    }
}