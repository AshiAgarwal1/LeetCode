class Solution {
    public int subsetSum(int []nums,int k){
        int n=nums.length;
        int[] prev=new int[k+1];
        if(nums[0]==0) prev[0]=2;
        else prev[0]=1;
        if(nums[0]!=0 && nums[0]<=k) prev[nums[0]]=1;
        for(int i=1;i<n;i++){
            int[] curr=new int[k+1];
            for(int target=0;target<=k;target++){
                int notTake=prev[target];
                int take=0;
                if(nums[i]<=target) take=prev[target-nums[i]];
                curr[target]=take+notTake;
            }
            prev=curr;
        }
        return prev[k];
    }
    public int canPartition(int[] nums,int d) {
        int totalSum=0;
        for(int i:nums) totalSum+=i;
        if(totalSum-d < 0 || (totalSum-d) % 2!=0) return 0;
        
        return subsetSum(nums,(totalSum-d)/2);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return canPartition(nums,target);
    }
}