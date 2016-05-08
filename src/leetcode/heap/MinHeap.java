package leetcode.heap;

import java.util.Arrays;

/**
 * 参考jdk源码 PriorityQueue，实现最小堆（优先级队列）
 * @author nxiangbo
 *
 * @param <E>
 */
public class MinHeap<E> {
	private Object[] queue;
	private int size = 0;
	
	private static int DEFAULT_SIZE = 10;
	
	public MinHeap(){
		this(DEFAULT_SIZE);
	}
	
	public MinHeap(int initialCapacity){
		this.queue = new Object[initialCapacity];
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	public boolean offer(E e){
		if(e==null){
			throw new NullPointerException();
		}
		int i = size;
		if(size>=queue.length){
			grow(i+1);
		}
		
		size = i+1;
		if(size==0){
			queue[0] = e;
		} else{
			siftUp(i,e);
		}
		return true;
	}
	
	public E peek(){
		if(size==0){
			return null;
		}
		return (E) queue[0];
	}
	
	public E poll(){
		if(size==0){
			return null;
		}
		
		int s = --size;
		E result = (E) queue[0];
		E x = (E) queue[s];
		queue[s] = null;
		if(s!=0){
			siftDown(0,x);
		}
		return result;
	}

	private void siftDown(int k, E x){
		@SuppressWarnings("unchecked")
		Comparable<? super E> key = (Comparable<? super E>) x;
		int half = size>>>1;
		while(k<half){
			int child = (k<<1)+1;
			E c = (E) queue[child];
			int right = child+1;
			if(right<size && ((Comparable<? super E>)c).compareTo((E)queue[right])>=0){
				c = (E) queue[child = right];
			}
			if(key.compareTo(c)<=0){
				break;
			}
			
			queue[k] = c;
			k = child;
		}
		queue[k] = key;
		
	}
	@SuppressWarnings("unchecked")
	private void siftUp(int k, E x) {
		Comparable<? super E> key = (Comparable<? super E>) x;
		while(k>0){
			int parent = (k-1)>>>1;
			Object e = queue[parent];
			if(key.compareTo((E) e)>=0){
				break;
			}
			queue[k] = e;
			k = parent;
		}
		queue[k] = key;
	}
	
	private void grow(int minCapacity){
		int oldCapacity = queue.length;
		int newCapacity = oldCapacity+oldCapacity>>1;
		queue = Arrays.copyOf(queue, newCapacity);
	}
	
	
	
}
