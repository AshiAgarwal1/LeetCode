class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        //we need [value,original index]
        int[][] arr=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        mergeSort(arr,0,n-1,ans);
        List<Integer> result=new ArrayList<>();
        for (int x:ans) {
            result.add(x);
        }
        return result;
    }
    static void mergeSort(int[][] arr,int left,int right,int[] ans){
        if(left>=right) return;
        int mid=left+(right-left)/2;
        mergeSort(arr,left,mid,ans);
        mergeSort(arr,mid+1,right,ans);
        merge(arr,left,mid,right,ans);
    }
    static void merge(int[][]arr,int left,int mid,int right,int[] ans){
        int i=left;
        int j=mid+1;
        int rightCount=0;
        int[][] temp=new int[right-left+1][2];
        int k=0;
        while(i<=mid && j<=right){
            if(arr[i][0]<=arr[j][0]){
                //how many smaller right ele have been placed before this ele
                //put that count into original idx 
                ans[arr[i][1]]+=rightCount;
                temp[k++]=arr[i++];
            }
            else{//right ele is smaller
            rightCount++;
            temp[k++]=arr[j++];//put right ele,idx in temp
            }
        }
        while(i<=mid){
            ans[arr[i][1]]+=rightCount;
            temp[k++]=arr[i++];
        }
        while(j<=right){
            temp[k++]=arr[j++];
        }
        for(int x=0;x<temp.length;x++){
            arr[left+x]=temp[x];
        }
    }
}