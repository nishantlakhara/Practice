package threads;

public class NewThread implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println("I am running.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main method starts");
		Thread t = new Thread(new NewThread());
		t.start();
		Thread.sleep(5000);
		t.join();
		System.out.println("main method ends");
	}
}
