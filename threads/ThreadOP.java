class UserThread extends Thread{

	public void run(){

		System.out.println("User Thread started");
	}
}

class ThreadOP{

	public static void main(String[] args){

		System.out.println("program started..");
		int x = 56 + 34;

		System.out.println("sum is "+ x);

		// Thread...
		Thread t = Thread.currentThread();
		String tname = t.getName();
		System.out.println("current running thread is "+ tname);
 
		// set name
		t.setName("MyMain");
		System.out.println("current running thread is "+ t.getName());

		try{
			Thread.sleep(5000);
		} catch(Exception e){

		}

		System.out.println(t.getId());

		// going to start user defined thread

		System.out.println("program ended..");

		UserThread thread = new UserThread();
		thread.start();
	}
}