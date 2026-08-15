class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int ele=nums[0];
        int cnt=0;
        for(int i=0;i<n;i++){
         if(cnt==0){
            cnt=1;
            ele=nums[i];
        }   
        else if(nums[i]==ele) cnt++;
        else cnt--;
        }
        //verify
        //if majority ele exists it has to be this ele
        int cnt1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele) cnt1++;
        }
        if (cnt1>n/2) return ele;
        else return -1;
    }
}