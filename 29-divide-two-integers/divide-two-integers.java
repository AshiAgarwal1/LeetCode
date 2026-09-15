class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor) return 1;
        boolean sign=true;
        if(dividend>=0 && divisor<0) sign=false;
        else if(dividend<=0 && divisor>0) sign=false;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        long quo=0;
        while(n>=d){
            int cnt=0;
            while(n>=(d<<(cnt+1))){
                cnt++;
            }
            quo+=(1L<<cnt);
            n-=(d<<cnt);
        }
        if(quo>Integer.MAX_VALUE && sign) return Integer.MAX_VALUE;
        if(quo>Integer.MAX_VALUE && !sign) return Integer.MIN_VALUE;
        return sign? (int)quo:(int)-quo;
    }
}