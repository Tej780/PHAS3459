package Exam1Prep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ExoAnalysis {
	
	static ArrayList<Exoplanet> transit = new ArrayList<Exoplanet>();
	static ArrayList<Exoplanet> rv = new ArrayList<Exoplanet>();
	static ArrayList<Exoplanet> imaging = new ArrayList<Exoplanet>();
	static ArrayList<Exoplanet> micro = new ArrayList<Exoplanet>();
	
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
			int number = 0;
			double minDist=Double.POSITIVE_INFINITY;
			double min;
			while((line=br.readLine()) !=null){
				number++;
				Scanner s = new Scanner(line);
				s.next();//skips first line of file
				String[] fields=line.split(",");
				if(fields.length==6){
					if((min=Double.parseDouble(fields[5]))<minDist){
						minDist=min;
					}
				}
				parseData(fields);
				s.close();	
			}
			System.out.println("The minimum distance to Earth is:"+minDist);
			System.out.println("The number of Exoplanets is: "+number);
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		
	}


	private static void parseData(String[] fields) {
		if(fields[2].equals("Transit")){
			Exoplanet ex = new Exoplanet(fields);
			transit.add(ex);
		}else if(fields[2].equals("RV")){
			Exoplanet ex = new Exoplanet(fields);
			rv.add(ex);
		}else if(fields[2].equals("Microlensing")){
			Exoplanet ex = new Exoplanet(fields);
			micro.add(ex);
		}else if(fields[2].equals("Imaging")){
			Exoplanet ex = new Exoplanet(fields);
			imaging.add(ex);
		}
		
	}
	
	public static void main(String[] args){
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2014-15/exoplanets.txt");
		System.out.println(transit);
	}
}
