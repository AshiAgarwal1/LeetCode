class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        int[] hash=new int[n];
        int[] dp=new int[n];
        int maxi=1;
        int last_idx=0;
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && dp[i]<dp[prev]+1){
                    dp[i]=dp[prev]+1;
                    hash[i]=prev;
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
                last_idx=i;
            }
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(nums[last_idx]);
        while(hash[last_idx]!=last_idx){
            last_idx=hash[last_idx];
            temp.add(nums[last_idx]);
        }
        return temp;
    }
}