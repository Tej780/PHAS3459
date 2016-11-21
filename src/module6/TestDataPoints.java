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

public class TestDataPoints {



	/**
	 * Gets data from a url represented by a url string
	 * @param url
	 */
	public static Collection<DataPoint> dataFromURL(String url){
		Collection<DataPoint> data = new ArrayList<DataPoint>();//holds all DataPoints
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
		return data;
	}

	public static void main(String[] args){
		Collection<DataPoint> data=dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		for(DataPoint dp : data){
			System.out.println(dp);
		}
	}
}
