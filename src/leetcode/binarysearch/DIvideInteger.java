package leetcode.binarysearch;

public class DIvideInteger {
	public int divide(int dividend, int divisor) {
        int ans = 0;
        int flag = 1;
        if(dividend==0){
            return 0;
        }
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        
        if(dividend<0 && divisor>0){
            dividend = 0-dividend;
            flag = -1;
        }
        
        if(dividend>0 && divisor<0){
            divisor = 0-divisor;
            flag = -1;
        }
        
        if(dividend==Integer.MAX_VALUE&&divisor==1||dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        
        if(dividend==Integer.MIN_VALUE&&divisor==1){
            return Integer.MIN_VALUE;
        }
        if(dividend==Integer.MAX_VALUE&&divisor==-1){
            return -Integer.MAX_VALUE;
        }
        long answer = ldivide(Math.abs((long)dividend),Math.abs((long)divisor));
        if(answer>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        } else{
            ans = (int)answer;
            return (flag==-1)?(0-ans):ans;
        }
        
    }
    
    public long ldivide(long dividend, long divisor){
        if(dividend<divisor) return 0;
        long sum = divisor;
        long mul = 1;
        
        while(sum+sum<=dividend){
            sum+=sum;
            mul+=mul;
        }
        
        return mul+ldivide(dividend-sum, divisor);
    }
}
