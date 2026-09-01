class Solution {
    public int findLongestChain(int[][] pairs) {
        //greedy based solution sort on earlier ending so more future pairs
        int n=pairs.length;
        //therefore sorting on ending val
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int prev=pairs[0][1];
        int ans=1;
        for(int ind=1;ind<n;ind++){
            int curr=pairs[ind][0];
            if(prev<curr){
                ans++;
                prev=pairs[ind][1];//new end time
            }
        }
        return ans;
    }
}