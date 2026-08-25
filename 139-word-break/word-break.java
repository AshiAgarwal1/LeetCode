class Solution {
    private Boolean[] dp;
    int n;
    private boolean solve(int idx,String s,List<String> wordDict){
        if(idx==n) return true;
        if(dp[idx] != null) return dp[idx];
        for(int endIdx=idx+1;endIdx<=n;endIdx++){
            String split=s.substring(idx,endIdx);
            if(wordDict.contains(split) && solve(endIdx,s,wordDict)) return dp[idx]=true;
        }
        return dp[idx]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        n=s.length();
        dp=new Boolean[n];
        return solve(0,s,wordDict);
    }
}