class Solution {
    public void rev(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
              int temp=matrix[i][j];
              matrix[i][j]=matrix[j][i];  
              matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            rev(matrix[i]);
        }
    }
}