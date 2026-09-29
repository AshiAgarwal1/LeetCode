class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n=nums.length;
        int maxi=1;
        int[] dp=new int[n];
        int[] cnt=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]>nums[prev]){
                    if(dp[i]<dp[prev]+1){
                        dp[i]=1+dp[prev];
                        cnt[i]=cnt[prev];
                    }
                    else if(dp[i]==dp[prev]+1)
                        cnt[i]+=cnt[prev];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(maxi==dp[i]) c+=cnt[i];
        }
        return c;
    }
}