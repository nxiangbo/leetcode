package leetcode;

public class ClimbingStairs {
	  public static int climbStairs(int n) {
//	        if(n==1){
//	        	return 1;
//	        } else if(n==2){
//	        	return 2;
//	        }else{
//	        	return climbStairs(n-1)+climbStairs(n-2);
//	        }
		  int[] result = new int[n+1];
		  result[0] = 1;
		  result[1] = 1;
		  for (int i = 2; i < result.length; i++) {
			result[i] = result[i-1]+result[i-2];
		}
		  return result[n];
	  }
	  
	  public static int climbStairsFaster(int n){
		  if(n<4){
			  return n;
		  }
		  int a = 2;
		  int b = 3;
		  int c = 5;
		  for (int i = 5; i <= n; i++) {
			a = c;
			c = b+a;
			b = a;
		}
		 return c; 
	  }
}
