class Solution {
    long MOD=1000000007;
    public long power(long a,long b){
        long ans=1;
        while(b>0){
            if(b%2==1){
                ans=(ans*a)%MOD;
            }
            a=(a*a)%MOD;
            b=b/2;
        }
        return ans;
    }
    public int countGoodNumbers(long n) {
        long even=(n+1)/2;
        long odd=n/2;
        return (int)((power(5,even)*power(4,odd))%MOD);
    }
}