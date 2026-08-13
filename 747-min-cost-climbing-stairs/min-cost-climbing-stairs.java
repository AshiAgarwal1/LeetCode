class Solution {
    int[] dp;
    public int solve(int idx,int[] cost){
        if(idx>=cost.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int a=cost[idx]+solve(idx+1,cost);
        int b=cost[idx]+solve(idx+2,cost);
        return dp[idx]=Math.min(a,b);
    }
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(0,cost),solve(1,cost));
    }
}