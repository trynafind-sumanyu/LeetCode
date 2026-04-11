class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];

        for(int p : prices){
            if(p < minPrice){
                minPrice = p;
            }
            profit = Math.max(profit,p-minPrice);
        }
        return profit;
    }
}
