package leetcode.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElement {
	public static  List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> result = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer num : nums) {
			Integer freq = map.get(num);
			map.put(num, (freq == null) ? 1 : freq + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.offer(entry.getValue());
			if (pq.size() > k) {
				pq.poll();
			}
			
		}
		List<Integer> temp = new ArrayList<>();
		while(!pq.isEmpty()){
			temp.add(pq.poll());
		}
		Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
		for (Integer integer : temp) {
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				
				if(integer.equals(entry.getValue())&&!result.contains(entry.getKey())){
					result.add(entry.getKey());
				}
			}
		}
//		for (Integer integer : result) {
//			System.out.println(integer);
//		}
		Collections.reverse(result);
		return result;

	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		topKFrequent(nums, k);
	}
}
