class Solution {
    void merge(int[] nums,int low,int mid,int high){
        int left=low;
        int right=mid+1;
        int[] temp=new int[high-low+1];
        int k=0;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right])  temp[k++]=nums[left++];
            else temp[k++]=nums[right++];
        }
        while(left<=mid) temp[k++]=nums[left++];
        while(right<=high) temp[k++]=nums[right++];
        //transfer ele from temp to arr 
        System.arraycopy(temp,0,nums,low,temp.length);
    }
    int countPairs(int[] nums,int low,int mid,int high){
        int right=mid+1;
        int cnt=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i]>2L*nums[right]) right++;
            cnt+= right-(mid+1);
        }
        return cnt;
    }
    int mergeSort(int[] nums,int low,int high){
        int cnt=0;
        if(low>=high) return cnt;
        int mid=low+(high-low)/2;
        cnt+=mergeSort(nums,low,mid);
        cnt+=mergeSort(nums,mid+1,high);
        cnt+=countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return cnt;
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        return mergeSort(nums,0,n-1);
    }
}