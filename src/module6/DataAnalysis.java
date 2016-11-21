package module6;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

	private static Collection<DataPoint> data = new ArrayList<DataPoint>();//holds all DataPoints
	private static Collection<Theory> theories = new ArrayList<Theory>();//holds theories
	/**
	 * Gets data from a url represented by a url string
	 * @param url
	 */
	public static void dataFromURL(String url){
		try{
			//get data from URL
			URL u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			//Turn each line into a DataPoint object before adding to ArrayList of DataPoints
			String line="";
			while((line=br.readLine()) !=null){
				DataPoint dp = LabelledDataPoint.parse(line);
				data.add(dp);
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}


	private static Theory bestTheory(Collection<DataPoint> data,
			Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		System.out.println(bestGoodnessOfFit);
		return bestTheory;
	}

	public static void main(String[] args) {
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		/*
		Theory one = new PowerLawTheory(2);
		Theory two = new PowerLawTheory(2.05);
		Theory three = new QuadraticTheory(1,10,0);
		theories.add(one);
		theories.add(two);
		theories.add(three);
		ChiSquared c=new ChiSquared();
		Theory best =bestTheory(data,theories,c);
		System.out.println("The best theory is: "+best);
		 */

		//just for fun. Seems more useful than manually testing 3 theories

		for(double a=0;a<10;a+=0.05){
			for(double b=0;b<10;b+=0.05){
				for(double c=0;c<10;c+=0.05){
					QuadraticTheory q = new QuadraticTheory(a,b,c);
					theories.add(q);
				}
			}
		}
		
		for(double n=0;n<10;n+=0.001){
			PowerLawTheory p = new PowerLawTheory(n);
			theories.add(p);
		}
		System.out.println(theories.size());
		ChiSquared c=new ChiSquared();
		Theory best =bestTheory(data,theories,c);
		System.out.println("The best theory is: "+best);


	}
}
