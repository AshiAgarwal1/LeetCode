class Solution {
    public int f(int i,int j,int[] cuts,int[][] dp){
        if(i>j) return 0;
        int mini=Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind=i;ind<=j;ind++){
            int cost=cuts[j+1]-cuts[i-1]+f(i,ind-1,cuts,dp)+f(ind+1,j,cuts,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
    public int minCost(int n, int[] cuts) {
        int c=cuts.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int cut:cuts) list.add(cut);
        list.add(n);
        list.add(0,0);
        Collections.sort(list);
        int[] arr = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            arr[k] = list.get(k);
            }
        int[][] dp=new int[c+1][c+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return f(1,c,arr,dp);

    }
}