class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int mini=Integer.MAX_VALUE;
        int[][] dp=new int[n][n];
        
        for(int j=0;j<n;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int u=matrix[i][j]+dp[i-1][j];
                int ld=matrix[i][j];
                if(j-1>=0) ld+=dp[i-1][j-1];
                else ld+=(int)1e9;
                int rd=matrix[i][j];
                if(j+1<n) rd+=dp[i-1][j+1]; 
                else rd+=(int)1e9;
                dp[i][j]=Math.min(u,Math.min(ld,rd));
            }
        } 
        for(int j=0;j<n;j++){
            mini=Math.min(mini,dp[n-1][j]);
        }
        return mini;
    }
}