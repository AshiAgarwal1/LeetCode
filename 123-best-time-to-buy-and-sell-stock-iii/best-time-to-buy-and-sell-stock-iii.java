class Solution {
    public int f(int i,int buy,int cap,int[] prices,int n,int[][][] dp){
        if(i==n || cap==0) return 0;
        if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];
        if(buy==1){
            return dp[i][buy][cap]= Math.max(-prices[i]+f(i+1,0,cap,prices,n,dp) , f(i+1,1,cap,prices,n,dp));
        }
        return dp[i][buy][cap]= Math.max(prices[i]+f(i+1,1,cap-1,prices,n,dp) , f(i+1,0,cap,prices,n,dp));
        
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n][2][3];
        for(int[][] row: dp)
        for(int[] r:row)Arrays.fill(r,-1);
        return f(0,1,2,prices,n,dp);
    }
}