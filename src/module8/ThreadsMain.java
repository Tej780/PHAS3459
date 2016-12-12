package module8;

public class ThreadsMain {

	public static void main(String[] args) {
		Thread count = new Thread(new CountdownTask(10));
		Thread prime = new Thread(new PrimeNumberTask());
		prime.start();
		count.start();
		try {
			//waits for the count thread to finish executing before interrupting prime thread
			count.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Timer Thread interrupted");
		}
		prime.interrupt();
	}
}
