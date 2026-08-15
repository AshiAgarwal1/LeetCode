class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap();
        int n=nums.length;
        int req=(n/3)+1;
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i])==req) list.add(nums[i]);
            if(list.size()==2) break;
        }
        return list;
    }
}