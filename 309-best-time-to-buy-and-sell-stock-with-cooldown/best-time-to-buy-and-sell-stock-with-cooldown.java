class Solution {
    public int f(int i,int buy,int[] prices,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy]=Math.max(-prices[i]+f(i+1,0,prices,dp) , f(i+1,1,prices,dp));
        }
        return dp[i][buy]=Math.max(prices[i]+f(i+2,1,prices,dp) , f(i+1,0,prices,dp));
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] row: dp) Arrays.fill(row,-1);
        return f(0,1,prices,dp);
    }
}