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
        return bestTheory;
    }

	public static void main(String[] args) {
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		System.out.println(data);
		//bestTheory(data,);
		
		
		/*
		//just for fun. Seems more useful than manually testing 2 individual values
		double minChi = Double.POSITIVE_INFINITY;//better than setting an arbitrarily large limit
		double minN = Double.POSITIVE_INFINITY;
		//tests all theoretical functions within a given range
		//Could modify to test non integer powers, but don't want to lose marks for doing extra work (Again) :(
		for (int m=0;m<=10;m++){
			Theory t = new Theory(m);
			double chi = goodnessOfFit(t,data);
			System.out.println("Chi Squared for n = "+m+ ": "+chi);
			if(chi<minChi){
				minChi=chi;
				minN=m;

			}
		}
		System.out.println("The minimum Chi Squared value is: "+minChi+" for n = "+(int)minN);
		//come on, you wanted to know just as much
		System.out.println("The reduced Chi Square is: "+minChi/(data.size()-1));
		//hey, at least I didn't (yet) make a version with coefficients or adding powers of x
		 * 
		 */
		
	}
}
