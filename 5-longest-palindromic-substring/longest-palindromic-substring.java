class Solution {
    int[][] dp;
    public int solve(String s, int i, int j){
        if(i>j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return dp[i][j]=solve(s,i+1,j-1);
        return dp[i][j]=0;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int maxLen=Integer.MIN_VALUE;
        int start=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                //check if this substring os palindrome
                if (solve(s,i,j)==1){
                    //if its len > maxlen update
                    if(j-i+1>maxLen){
                        maxLen=j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}