class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int n=nums.length;
        int req=(n/3)+1;
        int cnt1=0, cnt2=0;
        int ele1=Integer.MIN_VALUE;
        int ele2=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(cnt1==0 && nums[i]!=ele2){
                cnt1=1;
                ele1=nums[i];
            }
            else if(cnt2==0 && nums[i]!=ele1){
                cnt2=1;
                ele2=nums[i];
            }
            else if(ele1==nums[i]) cnt1++;
            else if(ele2==nums[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        int count1=0,count2=0;

        for(int i=0;i<n;i++){
            if(ele1==nums[i]) count1++;
            if(ele2==nums[i]) count2++;
        }
        if(count1>=req) list.add(ele1);
        if(count2>=req) list.add(ele2);
        return list;
    }
}