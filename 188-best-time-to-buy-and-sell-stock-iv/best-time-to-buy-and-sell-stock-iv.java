class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2*k+1];
        
        for(int i=n-1;i>=0;i--){
            for(int tranNo=2*k-1;tranNo>=0;tranNo--){
               if(tranNo % 2==0){//buy
            dp[i][tranNo] = Math.max(-prices[i]+dp[i+1][tranNo+1], dp[i+1][tranNo]);
        }
        //sell
        else dp[i][tranNo] = Math.max(prices[i]+dp[i+1][tranNo+1], dp[i+1][tranNo]); 
            }
        }
        return dp[0][0];
    }
}