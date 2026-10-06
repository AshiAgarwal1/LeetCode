class Solution {
    public int f(int i,int tranNo,int k,int[] prices,int n,int[][] dp){
        if(i==n || tranNo==2*k) return 0;
        if(dp[i][tranNo]!=-1) return dp[i][tranNo];
        if(tranNo % 2==0){//buy
            return dp[i][tranNo] = Math.max(-prices[i]+f(i+1,tranNo+1,k,prices,n,dp), f(i+1,tranNo,k,prices,n,dp));
        }
        //sell
        return dp[i][tranNo] = Math.max(prices[i]+f(i+1,tranNo+1,k,prices,n,dp), f(i+1,tranNo,k,prices,n,dp));
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2*k];
        for(int[] row:dp) Arrays.fill(row,-1);

        return f(0,0,k,prices,n,dp);
    }
}