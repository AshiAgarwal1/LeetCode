class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int minPrice=prices[0];
        int max_profit=0;
        for(int i=0;i<n;i++){
            max_profit=Math.max(max_profit,prices[i]-minPrice);
            minPrice=Math.min(minPrice,prices[i]);
        }
        return max_profit;
    }
}