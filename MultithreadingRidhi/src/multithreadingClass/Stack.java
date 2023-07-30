package multithreadingClass;

public class Stack {
	
	private int[] array;
	private int stackTop;
	Object lock1;
	Object lock2;
	
	Stack(int capacity){
		
		array = new int[capacity];
		stackTop = -1;
		lock1 = new Object();   //only 1 lock should be used for this use case, to make push pop thread safe
		lock2 = new Object();
	}
	
	public boolean push(int ele) {
		synchronized (lock1) {        // Any object for look could work
			if(isFull()) return false; 
			++stackTop;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			array[stackTop] = ele;
			return true;
		}
		
	}
	
	public int pop() {
		
		synchronized (lock1) {
			if(isEmpty()) {
				return Integer.MIN_VALUE;
			}
			
			int obj = array[stackTop];
			array[stackTop] = Integer.MIN_VALUE;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stackTop--;
			return obj;
		}
		
		
	}
	
	private boolean isFull() {
		if(stackTop >= array.length - 1) return true;
		return false;
	}
	
	private boolean isEmpty() {
		if(stackTop < 0) return true;
		return false;
	}

}
