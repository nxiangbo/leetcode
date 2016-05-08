package leetcode.heap;

import java.util.PriorityQueue;

public class MinHeapTest {
	public static void main(String[] args) {
		MinHeap<Integer> heap = new MinHeap<>();
		heap.offer(12);
		heap.offer(32);
		heap.offer(14);
		heap.offer(92);
		heap.offer(42);
		System.out.println(heap.poll());
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.offer(12);
		queue.offer(32);
		queue.offer(14);
		queue.offer(6);
		queue.offer(92);
		queue.offer(42);
		System.out.println(queue.isEmpty());
	}
}
