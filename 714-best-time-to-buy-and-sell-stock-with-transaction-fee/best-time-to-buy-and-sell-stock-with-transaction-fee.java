class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int aheadNotBuy=0;
        int aheadBuy=0;
        int currNotBuy, currBuy;
        for(int i=n-1;i>=0;i--){
            currNotBuy = Math.max(prices[i]-fee + aheadBuy , aheadNotBuy);
            currBuy = Math.max(-prices[i] + aheadNotBuy , aheadBuy);
            aheadNotBuy=currNotBuy;
            aheadBuy=currBuy;
        }
        return aheadBuy;
    }
}