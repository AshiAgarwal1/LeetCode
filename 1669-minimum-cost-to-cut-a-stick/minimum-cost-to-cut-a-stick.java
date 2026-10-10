class Solution {
    public int minCost(int n, int[] cuts) {
        int c=cuts.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int cut:cuts) list.add(cut);
        list.add(n);
        list.add(0,0);
        Collections.sort(list);
        int[] arr=new int[list.size()];
        for(int k=0;k<list.size();k++) {
            arr[k]=list.get(k);
            }
        int[][] dp=new int[c+2][c+2];
        for(int i=c;i>=1;i--){
            for(int j=1;j<=c;j++){
               if(i>j) continue;
        int mini=Integer.MAX_VALUE;
        
        for(int ind=i;ind<=j;ind++){
            int cost=arr[j+1]-arr[i-1]+dp[i][ind-1]+dp[ind+1][j];
            mini=Math.min(mini,cost);
        }
        dp[i][j]=mini; 
            }
        }
return dp[1][c];
    }
}