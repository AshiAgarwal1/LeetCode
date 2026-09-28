class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        int[] curr=new int[amount+1];
        for(int T=0;T<=amount;T++){
            prev[T]=(T%coins[0]==0)?1:0;
        }
        for(int i=1;i<n;i++){
            for(int T=0;T<=amount;T++){
                int notTake=prev[T];
                int take=0;
                if(coins[i]<=T) take=curr[T-coins[i]];
                curr[T]=notTake+take;
            }
            prev=curr;
        }
        return prev[amount];
    }
}