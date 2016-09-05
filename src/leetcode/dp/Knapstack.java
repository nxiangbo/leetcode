package leetcode.dp;

public class Knapstack {
	public static int knapstack(int[] value, int[] weight, int capacity){
		int n = value.length;
		int[][] res = new int[n+1][capacity+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=capacity;j++){
				if(weight[i-1]<=j){
					res[i][j] = Math.max(value[i-1]+res[i-1][j-weight[i-1]], res[i-1][j]);
				} else{
					res[i][j] = res[i-1][j];
				}
				
			}
			
		}
		
		return res[n][capacity];
	}
	
	public static int knapstackII(int[] value, int[] weight, int capacity){
		int n = value.length;
		int[] res = new int[capacity+1];
		for(int i=1;i<=n;i++){
//			for(int v = capacity;v>=1;v--){
//				if(weight[i-1]<=v){
//					res[v] = Math.max(value[i-1]+res[v-weight[i-1]], res[v-1]);
//				} else{
//					res[v] = res[v-1];
//				}
//			}
			zeroOnePack(res, value[i-1], weight[i-1], capacity);
//			completePack(res, value[i-1], weight[i-1], capacity);
		}
		
		return res[capacity];
	}
	
	
	public static void zeroOnePack(int[] res, int value, int weight,int capacity){
		for(int v = capacity;v>=1;v--){
			if(weight<=v){
				res[v] = Math.max(value+res[v-weight], res[v-1]);
			} else{
				res[v] = res[v-1];
			}
		}
	}
	
	public static void completePack(int[] res, int value, int weight, int capacity){
		for(int v = 1;v<=capacity;v++){
			if(weight<=v){
				res[v] = Math.max(value+res[v-weight], res[v]);
			} else{
				res[v] = res[v];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] value = {60,100,120};
		int[] weight = {10,20,30};
		int capacity = 80;
		System.out.println(knapstack(value, weight, capacity));
		
		System.out.println(knapstackII(value, weight, capacity));
		
	}
}

