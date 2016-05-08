package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2 {
	public static void kthNumber(int n, int m, int k){
		if(k<=m*n&&n>0&&m>0&&k>0){
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			ArrayList<Integer> nums = new ArrayList<>();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					nums.add(i*j);
				}
			}
//			Collections.sort(nums);
			
			for (Integer integer : nums) {
				pq.offer(integer);
				if(pq.size()>(m*n-k+1)){
					pq.poll();
				}
			}

			System.out.println( pq.peek());;
		} else{
			return ;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			kthNumber(n, m, k);
		}
	}
}
