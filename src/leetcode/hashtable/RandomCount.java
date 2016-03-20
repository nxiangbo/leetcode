package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 此代码不是leetcode上的题目
 * 可用于统计数组中重复值的个数，是HashTable的典型应用。
 * @author nxiangbo
 *
 */
public class RandomCount {
	public static void randomCount(){
		Random random = new Random(47);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			int rand = random.nextInt(20);
			//map的get()方法：获取指定键所映射的值
			Integer freq = map.get(rand);
			map.put(rand, freq==null?1:freq+1);
		}
		System.out.println(map);
		
	}
	
	public static void main(String[] args) {
		randomCount();
	}
}
