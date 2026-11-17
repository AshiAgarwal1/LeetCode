class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int preSum=0,ans=0;
        for(int i=0;i<nums.length;i++){
            preSum+=(nums[i]==0)? -1:1;
            if(map.containsKey(preSum)) ans=Math.max(ans,i-map.get(preSum));
            else map.put(preSum,i);
        }
        return ans;
    }
}