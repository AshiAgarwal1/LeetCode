class Solution {
    public int f(int ind1,int ind2,String text1,String text2,int[][] dp){
        if(ind1 < 0 || ind2 < 0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        //matches
        if(text1.charAt(ind1)==text2.charAt(ind2))
            return dp[ind1][ind2]=1+f(ind1-1,ind2-1,text1,text2,dp);
        //not matches
        return dp[ind1][ind2]=Math.max(f(ind1-1,ind2,text1,text2,dp),f(ind1,ind2-1,text1,text2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return f(n-1,m-1,text1,text2,dp);
    }
}