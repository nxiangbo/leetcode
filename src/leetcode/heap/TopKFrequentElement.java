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
	
	public static  List<Integer> topKFrequentII(int[] nums, int k) {
		
		List<Integer>[] buckets = new List[nums.length+1];
		Map<Integer,Integer> freqMap = new HashMap<>();
		for (Integer num : nums) {
			freqMap.put(num,freqMap.get(num)==null?1:freqMap.get(num)+1);
		}
		
		for (Integer key : freqMap.keySet()) {
			int freq = freqMap.get(key);
			
			if(buckets[freq]==null){
				buckets[freq] = new ArrayList<>();
			}
			
			buckets[freq].add(key);
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i=buckets.length-1;i>=0&&res.size()<k;i--){
			if(buckets[i]!=null){
				res.addAll(buckets[i]);
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		topKFrequentII(nums, k);
	}
}
