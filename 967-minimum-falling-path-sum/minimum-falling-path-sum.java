class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int mini=Integer.MAX_VALUE;
        int[] prev=new int[n];

        for(int j=0;j<n;j++){
            prev[j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                int u=matrix[i][j]+prev[j];
                int ld=matrix[i][j];
                if(j-1>=0) ld+=prev[j-1];
                else ld+=(int)1e9;
                int rd=matrix[i][j];
                if(j+1<n) rd+=prev[j+1]; 
                else rd+=(int)1e9;
                curr[j]=Math.min(u,Math.min(ld,rd));
            }
            prev=curr;
        } 
        for(int j=0;j<n;j++){
            mini=Math.min(mini,prev[j]);
        }
        return mini;
    }
}