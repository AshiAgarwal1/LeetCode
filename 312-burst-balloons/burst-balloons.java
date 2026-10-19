class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }
        int[][] dp=new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j) continue;
                int maxi=Integer.MIN_VALUE;
                for(int ind=i;ind<=j;ind++){
                    int cost=arr[i-1]*arr[ind]*arr[j+1]+dp[i][ind-1]+dp[ind+1][j];
                    maxi=Math.max(maxi,cost);
                }
                dp[i][j]=maxi;
            }
        }
        return dp[1][n];
    }
}