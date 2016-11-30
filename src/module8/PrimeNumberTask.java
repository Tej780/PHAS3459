package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable{
	
	int largestPrime,currentInt;
	
	public PrimeNumberTask(){}
	@Override
	public void run() {
		if(Thread.currentThread().isInterrupted()){
			System.out.println(largestPrime);
			return;}
		ArrayList<Integer> primeArray=new ArrayList<Integer>();
		for (int i = 2;i<Integer.MAX_VALUE;i++){
			for(int j=2;j<i;j++){
				if(i%j==0){
					primeArray.add(i);
				}
			}
		}
		
	}

}
