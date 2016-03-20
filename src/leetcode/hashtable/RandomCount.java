package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * �˴��벻��leetcode�ϵ���Ŀ
 * ������ͳ���������ظ�ֵ�ĸ�������HashTable�ĵ���Ӧ�á�
 * @author nxiangbo
 *
 */
public class RandomCount {
	public static void randomCount(){
		Random random = new Random(47);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			int rand = random.nextInt(20);
			//map��get()��������ȡָ������ӳ���ֵ
			Integer freq = map.get(rand);
			map.put(rand, freq==null?1:freq+1);
		}
		System.out.println(map);
		
	}
	
	public static void main(String[] args) {
		randomCount();
	}
}
