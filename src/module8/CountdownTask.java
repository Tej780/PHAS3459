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
			if(timeElapsed%1000==0){
				System.out.println(timeLimit-timeElapsed/1000);
			}
		}
		return;
	}

}
