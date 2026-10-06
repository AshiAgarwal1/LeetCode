class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[] after=new int[2*k+1];
        
        for(int i=n-1;i>=0;i--){
             int[] curr=new int[2*k+1];
            for(int tranNo=2*k-1;tranNo>=0;tranNo--){
               if(tranNo % 2==0){//buy
            curr[tranNo] = Math.max(-prices[i]+after[tranNo+1], after[tranNo]);
        }
        //sell
        else curr[tranNo] = Math.max(prices[i]+after[tranNo+1], after[tranNo]); 
            }
            after=curr;
        }
        return after[0];
    }
}