class Solution {
    public int missingNumber(int[] nums) {
        int xor=nums.length;//indices are till n-1 so we need to xor with the last ele also
        for(int i=0;i<nums.length;i++){
            xor^=i^nums[i];
        }
        return xor;
    }
}