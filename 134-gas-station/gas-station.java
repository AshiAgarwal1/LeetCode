class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int totalGas=0;
        int totalCost=0;
        for(int val:gas){
            totalGas+=val;
        }
        for(int val:cost){
            totalCost+=val;
        }
        if(totalGas<totalCost) return -1;
        //unique soln always exist
        int total=0; 
        int result=0;
        for(int i=0;i<n;i++){
            total=total+gas[i]-cost[i];
            if(total<0){
                total=0;
                result=i+1;
            }
        }
        return result;
    }
}