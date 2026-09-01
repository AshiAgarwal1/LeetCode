class Solution {
    public int findLongestChain(int[][] pairs) {
        int n=pairs.length;
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int ind=0;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                if(pairs[prev][1]<pairs[ind][0]) dp[ind]=Math.max(dp[ind],1+dp[prev]);
            }
            ans=Math.max(ans,dp[ind]);
        }
        return ans;
    }
}