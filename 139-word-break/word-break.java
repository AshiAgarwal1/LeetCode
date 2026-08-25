class Solution {
    private Boolean[] dp;
    int n;
    private boolean solve(int idx,String s,List<String> wordDict){
        if(idx==n) return true;
        if(dp[idx] != null) return dp[idx];
        for(int l=1;l<=n-idx;l++){
            String split=s.substring(idx,idx+l);
            if(wordDict.contains(split) && solve(idx+l,s,wordDict)) return dp[idx]=true;
        }
        return dp[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        n=s.length();
        dp=new Boolean[n];
        return solve(0,s,wordDict);
    }
}