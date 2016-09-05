package leetcode;

import java.util.Scanner;

public class Main_letv {
	public static int deal(int a, int b){
		if(b<a){
			return 0;
		}
		
		int count =0;
		
		int mod = a%5;
		for(int i=5-mod;i<=b-a;i=i+5){
			int pay = a+i;
			if(pay<=b&&i>=(pay*0.05)&&i<=(pay*0.1)){
				count++;
				System.out.println("true");
			}
//			System.out.println(pay);
			if(i>pay*0.2 || pay>b){
				break;
			}
			
			System.out.println(pay+"  "+i+" "+i/(pay*1.0));
		}
		
		return count;
	}
	
	public static void main(String[] args) {
//		int a = 23;
//		int b = 100;
//		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(deal(a, b));
		}
		
	}
	
}
