package threads;

public class SampleHook {
	public static void main(String[] args) {
		A a = new A();
		a.start();
		
		Thread shutdownHook = new Thread() {
			public void run() {
				for(int i=0;i<10;i++)
					System.out.println("Running gracefully");
			}
		};
		
		Object syncObject = null;
		synchronized(syncObject) {
		    try {
		        // Calling wait() will block this thread until another thread
		        // calls notify() on the object.
		        syncObject.wait();
		    } catch (InterruptedException e) {
		        // Happens if someone interrupts your thread.
		    }
		}
		
		Runtime.getRuntime().addShutdownHook(shutdownHook);
	}
}

class A extends Thread {
	public void run() {
		for(int i=0;i>=0;i++) {
			System.out.println(i);
		}
	}
	
	
}
