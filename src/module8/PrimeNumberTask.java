package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable{


	public PrimeNumberTask(){}
	@Override
	public void run() {

		ArrayList<Integer> primeArray=new ArrayList<Integer>();
		primeArray.add(2);//only even prime
		for (int i = 3;i<Integer.MAX_VALUE;i+=2){//no point checking even numbers
			boolean isPrime=true;
			for(Integer j:primeArray){
				if(j<=Math.sqrt(i)){
				if(i%j==0){
					isPrime=false;
					break;
				}
				}else{break;}
			}
			if(isPrime==true){
				primeArray.add(i);
			}
			if(Thread.currentThread().isInterrupted()){
				System.out.println("The largest integer checked was "+i);
				System.out.println(primeArray.size()+" prime numbers were found!");
				System.out.println("The largest prime found is: "+primeArray.get(primeArray.size()-1));
				System.out.println("Interestingly, the largest integer checked is often the biggest prime."
						+ " I think this is purely because primes are so dense. It is possible for the numbers to differ, it just doesn't happen often.");
				return;
			}
		}

	}

}
