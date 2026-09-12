class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor) return 1;
        long quotient=0;
        long n=dividend;
        long d=divisor;
        boolean sign=true;
        if(n<=0 && d>0) sign=false;
        if(n>=0 && d<0) sign=false;
        long n1=Math.abs(n);
        long d1=Math.abs(d);
        while(n1>=d1){
            int cnt=0;
            while(n1>=(d1<<(cnt+1))){
                cnt++;
            }
            quotient+=(1L<<cnt);
            n1-=(d1<<cnt);
        }
        if(quotient==(1L<<31) && sign==true)
        return Integer.MAX_VALUE;
        if(quotient==(1L<<31) && sign==false)
        return Integer.MIN_VALUE;
        return (sign)?(int)quotient:(int)-quotient;

    }
}