package leetcode.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder2 {
	private Queue<Long> larger = new PriorityQueue<>();
	private Queue<Long> smaller = new PriorityQueue<>(1000,(Comparator)ReverseComparator.REVERSE_ORDER);
	
	private static class ReverseComparator implements Comparator<Comparable<Object>>{
	     static final ReverseComparator REVERSE_ORDER = new ReverseComparator();
	     public int compare(Comparable<Object> c1, Comparable<Object> c2) {
           return c2.compareTo(c1);
       }
	}
	
	 // Adds a number into the data structure.
    public void addNum(int num) {
        larger.add((long) num);
        smaller.add(-larger.poll());
        if(larger.size()<smaller.size()){
            larger.add(-smaller.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return larger.size()>smaller.size()?larger.peek():(larger.peek()-smaller.peek())/2.0;
    }
    
    public static void main(String[] args) {
		MedianFinder2 mf = new MedianFinder2();
		mf.addNum(2);
		mf.addNum(3);
		mf.addNum(4);
		System.out.println(mf.findMedian());
	}
}
