package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainBai {
	public static int luckyNumber(int a , int b){
		String stra = Integer.toString(b);
		while(!isLucky(a, b)){
			a++;
		}
		return a;
	}
	
	public static boolean isLucky(int a, int b){
		ArrayList<Integer> aList = new ArrayList<>();
		ArrayList<Integer> bList = new ArrayList<>();
		ArrayList<Integer> indexs = new ArrayList<>();
		while(a>0){
			aList.add(a%10);
			a = a/10;
		}
		while(b>0){
			bList.add(b%10);
			b = b/10;
		}
		for (int i =0; i <bList.size(); i++) {
			if(aList.contains(bList.get(i))){
				indexs.add(aList.indexOf(bList.get(i)));
			}
		}
		
		
		ArrayList<Integer> backup = new ArrayList<>();
		backup = (ArrayList<Integer>) indexs.clone();
		Collections.sort(backup);
		if(indexs.size()==bList.size()&&indexs.equals(backup)){
			return true;
		} else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(luckyNumber(a, b));
		}
	}
}
