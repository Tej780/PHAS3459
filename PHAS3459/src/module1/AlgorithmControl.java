package module1;

public class AlgorithmControl {

	
	public static void loop(){
		for (int i = 1; i < 21; i++){
			System.out.println(i);
		}
		
	}
	
	public static void decrement(){
		int x = 8;
		while(x >= -10){
			System.out.println(x);
			x--;
			
		}
		
	}
	
	public static void increment(){
		double y = 1.2;
		while(y <= 10.9){
			System.out.println(y);
			y += 0.4;
			
		}
		
	}
	/*
	public static void timer(){
		long timeNow = System.currentTimeMillis();
		long initialTime = timeNow;
		int i = 0;
		while (timeNow < (initialTime + 5000)){
			timeNow = System.currentTimeMillis();
			i++;
			if(i%200 == 0){
				System.out.println(i);
			}
		}
		
	} 
	*/
	
	public static int timer(long maxTime, long loopSteps){
		long timeNow = System.currentTimeMillis();
		long initialTime = timeNow;
		int i = 0;
		while (timeNow < (initialTime + maxTime)){
			timeNow = System.currentTimeMillis();
			i++;
			if(i%loopSteps == 0){
				System.out.println(i);
			}
		}
		return i;
	} 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//loop();
		//decrement();
		//increment();
		int totalLoops500= timer(10000, 500);
		int totalLoops50000 = timer(10000,50000);
		System.out.println(totalLoops500);
		System.out.println(totalLoops50000);
	}

}
