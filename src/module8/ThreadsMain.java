package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		Thread count = new Thread(new CountdownTask(10));
		Thread prime = new Thread(new PrimeNumberTask());
		prime.start();
		count.start();
		try {
			count.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prime.interrupt();

	}

}
