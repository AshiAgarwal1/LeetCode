class Solution {
    int[] dp;
    public int dfs(int[] coins,int amount){
            //base case
            if(amount==0) return 0;
            if(dp[amount]!=-1) return dp[amount];
            int res=Integer.MAX_VALUE;
            for(int coin:coins){
                if(amount-coin>=0){
                    int result=dfs(coins,amount-coin);
                    if(result!=Integer.MAX_VALUE){
                        res=Math.min(res,1+result);
                    }
                }
            }
            dp[amount]=res;
            return res;
        }
    public int coinChange(int[] coins, int amount) {
        dp= new int[amount+1];
        Arrays.fill(dp,-1);
        int minCoins= dfs(coins,amount);
        return minCoins==Integer.MAX_VALUE? -1: minCoins;
    }
}