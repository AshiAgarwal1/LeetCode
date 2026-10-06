class Solution {
    public int f(int i,int buy,int[] prices,int n,int[][] dp){
        if(i==n) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+f(i+1,0,prices,n,dp) , f(i+1,1,prices,n,dp));
        }
        else //sell
            profit=Math.max(prices[i]+f(i+1,1,prices,n,dp) , f(i+1,0,prices,n,dp));
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int[] row:dp) Arrays.fill(row,-1);
        return f(0,1,prices,n,dp);
    }
}