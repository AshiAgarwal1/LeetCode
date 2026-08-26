class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int ind=0;ind<n;ind++){
            for(int prev=0;prev<ind;prev++){
                if(nums[prev]<nums[ind]){
                    dp[ind]=Math.max(dp[ind],1+dp[prev]);
                }
            }
            ans=Math.max(ans,dp[ind]);
        }
        return ans;
    }
}