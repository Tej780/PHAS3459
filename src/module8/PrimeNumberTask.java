package module8;

import java.util.ArrayList;

public class PrimeNumberTask implements Runnable{

	public PrimeNumberTask(){}

	@Override
	public void run() {

		//stores all primes found
		ArrayList<Integer> primeArray=new ArrayList<Integer>();

		//one isn't prime (fundemental theorem of arithmetic)
		//only even prime, might as well add it now. Allows second loop to work, effectively initialising the primeArray
		primeArray.add(2);

		for (int i = 3;i<Integer.MAX_VALUE;i+=2){//no point checking even numbers, only check odd numbers from primality

			boolean isPrime=true;

			for(Integer j:primeArray){

				//only checks divisor up to square root of the number for which we are checking primality
				if(j<=Math.sqrt(i)){

					if(i%j==0){//if the number can be divided by a prime, it itself cannot be prime
						isPrime=false;
						break;//if not prime, no point in carrying on the loop
					}
					
				}else{break;}//for divisors higher than square root of the number, just end the loop
			}
			
			if(isPrime==true){
				primeArray.add(i);
			}
			
			if(Thread.currentThread().isInterrupted()){
				System.out.println("The largest integer checked was "+i);
				System.out.println(primeArray.size()+" prime numbers were found!");
				System.out.println("The largest prime found is: "+primeArray.get(primeArray.size()-1));
				System.out.println("\nInterestingly, the largest integer checked is often the biggest prime.\n"
						+ "I think this is purely because primes are so dense(within the given time frame and based on the parameters set).\n"
						+ "It is possible for the numbers to differ, it just doesn't happen often.");
				return;
			}
		}
	}
}
