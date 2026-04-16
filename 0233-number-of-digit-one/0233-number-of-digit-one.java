class Solution {
    public int countDigitOne(int n) {
        if(n < 10){
            if(n == 0){
                return 0;
            }
            return 1;
        }

        //n = 635
        int len = (int)Math.log10(n)+1;
        // len = 3

        int base = (int)Math.pow(10,len-1);
        // base = 100

        int mult = n/base;
        int rem = n%base;

        int numOfOnes = 0;

        if(mult == 1){
            numOfOnes = n - base + 1;
        }
        else {
            numOfOnes = base;
        }
 
        return countDigitOne(base-1)*mult + numOfOnes + countDigitOne(rem);

    }
}