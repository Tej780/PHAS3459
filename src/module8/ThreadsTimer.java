package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadsTimer {

	
	public static void main(String[] args) {
		singleThread();
		multiThread(4);

	}
	
	public static void singleThread(){
		long startTime = System.currentTimeMillis();
		long nPoints =  10000000;
		MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints);
		double pi = task.call();
		long timeElapsed = System.currentTimeMillis() - startTime;
		System.out.println(pi);
		System.out.println(timeElapsed);
	}

	public static void multiThread(int nt){
		long startTime = System.currentTimeMillis();
		long nPoints =  10000000;
		int nThreads = nt;
		ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
		List<Future<Double>> futures = new ArrayList<Future<Double>>();
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			MonteCarloPiCalculatorTask task = new
					MonteCarloPiCalculatorTask(nPoints/nThreads);
			Future<Double> future = threadPool.submit(task);
			futures.add(future);
		}
		double sum = 0.0;
		for (int iThread = 0; iThread < nThreads; ++iThread) {
			double result=0.0;
			try {
				result = futures.get(iThread).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			sum += result;
		}
		threadPool.shutdown();
		double pi = sum/nThreads;
		long timeElapsed = System.currentTimeMillis() - startTime;
		System.out.println(pi);
		System.out.println(timeElapsed);

	}

}
