class Solution {
    public int smallestNumber(int n, int t) {
        
        while(mult(n)%t != 0){
            n++;
        }
        return n;
    }

    private int mult(int n){
        int prod = 1;

        while(n > 0){
            int rem = n%10;
            prod *= rem;
            n /= 10;
        }
        return prod;
    }
}