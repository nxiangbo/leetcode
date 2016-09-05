package leetcode;

import java.util.Scanner;

public class Main_letv2 {
	public static int circle(int s){
		if(s<=0){
			return 0;
		}
		
		int radius = (int) Math.sqrt(s);
		
		int count =0;
		for(int i=radius+1;i>=1;i--){
			for(int j=s/2;j>=1;j--){
				if(i*i+j*j==s){
					count ++;
				}
				if(i*i+j*j<s){
					break;
				}
			}
		}
		
		if(radius*radius==s){
			count++;
		}
		
		return count*4;
	}
	
	public static void main(String[] args) {
//		int s = 25;
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int s = in.nextInt();
			System.out.println(circle(s));
		}
		
	}
}
