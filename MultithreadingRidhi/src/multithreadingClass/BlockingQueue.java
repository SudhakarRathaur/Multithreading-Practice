package multithreadingClass;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

	Queue<Integer> q;
	int capacity;
	
	BlockingQueue(int cap){
		q = new LinkedList<>();
		this.capacity = cap;
	}
	
	public boolean add(int item) {
		synchronized (q) {
			while(q.size() == capacity) {
				try {
					q.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			q.add(item);
			q.notifyAll();
			return true;
			
		}
	}
	
	public int remove() {
		synchronized (q) {
			
			while(q.size() == 0) {
				try {
					q.wait();  // adder1, adder2 
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			int element = q.poll();
			q.notifyAll();
			return element;
		}
	}
 }
