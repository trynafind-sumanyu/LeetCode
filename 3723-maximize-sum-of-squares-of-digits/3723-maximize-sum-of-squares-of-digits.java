class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num*9){
            return "";
        }

        int nine = sum/9;
        int rem = sum%9;
        StringBuilder sb = new StringBuilder();

        sb.append("9".repeat(nine));

        if (rem > 0){
            sb.append(rem);
        }

        sb.append("0".repeat(num-sb.length()));

        return sb.toString();
    }


}