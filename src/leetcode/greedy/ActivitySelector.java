package leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动选择问题 （算法导论--贪心算法）
 * 
 * @author nxiangbo
 *
 */

public class ActivitySelector {
	public static List<Integer> activitySelectorWithGreedy(int[] s, int[] f){
		int n = s.length;
		List<Integer> resSet = new ArrayList<>();
		resSet.add(0);
		int k =0;
		for(int m=1;m<n;m++){
			if(s[m]>=f[k]){
				resSet.add(m);
				k = m;
			}
		}
		return resSet;
	}
	public static void activitySelectorWithRecursive(int[] s, int[] f){
		int n = s.length;
		List<Integer> resSet = new ArrayList<>();
		activitySelectorWithRecursive(s, f, 0, n, resSet);
		for (Integer integer : resSet) {
			System.out.println(integer);
		}
	}
	public static void activitySelectorWithRecursive(int[] s, int[] f, int k, int n,List<Integer> resSet){
		int m = k+1;
		if(k==0){
			resSet.add(0);
		}
		while(m<n&&s[m]<f[k]){
			m++;
		}
		
		if(m<n){
			resSet.add(m);
			activitySelectorWithRecursive(s, f, m, n, resSet);
		} else{
			return;
		}
	}
	
	public static void main(String[] args) {
		int[] s = {1,3,0,5,3,5,6,8,8,2,12};
		int[] f = {4,5,6,7,9,9,10,11,12,14,16};
		
		List<Integer> result = activitySelectorWithGreedy(s, f);
		for (Integer integer : result) {
			System.out.println(integer);
		}
		
		activitySelectorWithRecursive(s, f);
	}
}
