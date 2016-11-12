package module5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class DataAnalysis {

	private static ArrayList<DataPoint> data = new ArrayList<DataPoint>();

	public static void dataFromURL(String url){
		try{
			URL u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line="";
			while((line=br.readLine()) !=null){
					DataPoint dp = DataPoint.parse(line);
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

	public static double goodnessOfFit(Theory ty,ArrayList<DataPoint> dps){
		double chiSquared = 0;
		for (int n = 0; n<dps.size();n++){
			DataPoint dp = dps.get(n);
			double x = dp.getX();
			double yTheory = ty.y(x);
			chiSquared += Math.pow((dp.getY()-yTheory), 2)/Math.pow(dp.getErr(), 2);
		}
		return chiSquared;
	}

	public static void main(String[] args) {
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
		double minChi = Double.POSITIVE_INFINITY;
		double minN = Double.POSITIVE_INFINITY;
		for (int m=0;m<=10;m++){
			Theory t = new Theory(m);
			double chi = goodnessOfFit(t,data);
			System.out.println("Chi Squared for n = "+m+ ": "+chi);
			if(chi<minChi){
				minChi=chi;
				minN=m;
				
			}
		}
		System.out.println("The minimum Chi Squared value is: "+minChi+" for n = "+minN);
		
	}

}
