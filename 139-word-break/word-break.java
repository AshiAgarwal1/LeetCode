class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[n]=true;
        Set<String> set=new HashSet<>(wordDict);
        for(int idx=n-1;idx>=0;idx--){
            for(int l=1;l<=n-idx;l++){
                String split=s.substring(idx,idx+l);
                if(set.contains(split) && dp[idx+l]) {
                    dp[idx]=true;
                    break;
            }
        }
        }
        return dp[0];
    }
}