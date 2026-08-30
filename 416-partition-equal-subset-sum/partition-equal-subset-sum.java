class Solution {
    //space optimized subsetsumtok
    public boolean subsetSum(int []nums,int k){
        boolean[] prev=new boolean[k+1];
        prev[0]=true;
        if(nums[0]<=k) prev[nums[0]]=true;
        for(int i=1;i<nums.length;i++){
            boolean[] curr=new boolean[k+1];
            curr[0]=true;
            for(int target=1;target<=k;target++){
                boolean notTake=prev[target];
                boolean take=false;
                if(nums[i]<=target) take=prev[target-nums[i]];
                curr[target]=take||notTake;
            }
            prev=curr;
        }
        return prev[k];
    }
    public boolean canPartition(int[] nums) {
        int totalSum=0;
        for(int i:nums) totalSum+=i;
        if(totalSum%2!=0) return false;
        int k=totalSum/2;
        return subsetSum(nums,k);
    }
}