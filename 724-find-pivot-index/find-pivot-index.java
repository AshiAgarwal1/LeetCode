class Solution {
    public int pivotIndex(int[] nums) {
       int total=0;
       int leftSum=0,rightSum=0;
       for(int num:nums){
        total+=num;
       } 
       for(int i=0;i<nums.length;i++){
        rightSum=total-leftSum-nums[i];
        if(leftSum==rightSum) return i;
        leftSum+=nums[i];
       }
       return -1;
    }
}