package module8;

public class CountdownTask implements Runnable{

	private int timeLimit;

	public CountdownTask(int numberInSeconds){
		timeLimit=numberInSeconds;
	}

	@Override
	public void run() {
		
		long startTime=System.currentTimeMillis();
		long timeElapsed=0;
		
		while(timeElapsed<timeLimit*1000){
			
			timeElapsed=System.currentTimeMillis()-startTime;
			
			if(timeElapsed%1000==0){//every whole second
				
				try {
					/*
					 * Since the CPU is so fast, the loop could run hundreds of times per millisecond
					 * To prevent the program from printing hundreds of times each second, I will wait a millisecond
					 * Since the timer and prime thread are seperate, this wont affect the overall computation
					 */
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("Timer Thread interrupted");
				}
				
				System.out.println(timeLimit-timeElapsed/1000);
			}
		}
	}
}
