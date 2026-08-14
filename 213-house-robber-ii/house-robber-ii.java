class Solution {
    public int helper(int[] nums) {
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<nums.length;i++){
            int pick=nums[i]+prev2;
            int notpick=prev1;
            int curr=Math.max(pick,notpick);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        //if there is only one house 
        if(n==1) return nums[0];
        //rob every house except first one 
        int[] temp1=Arrays.copyOfRange(nums,0,n-1);//last indx is excluded
        //rob every house except last one 
        int[] temp2=Arrays.copyOfRange(nums,1,n);
        return Math.max(helper(temp1),helper(temp2));//either first or last will be robbed as adjacent
    }
}