class Solution {
    public int rob(int[] nums) {
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
}