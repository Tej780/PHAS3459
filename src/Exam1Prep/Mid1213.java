package Exam1Prep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Mid1213 {

	/**
	 * Gets data from a url represented by a url string
	 * @param url
	 */
	public static HashMap<Integer,ArrayList<Double>> dataFromURL(String url){
		HashMap<Integer,ArrayList<Double>> dataMap = new HashMap<Integer,ArrayList<Double>>();
		try{
			//get data from URL
			URL u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			//Turn each line into a DataPoint object before adding to ArrayList of DataPoints
			String line="";
			while((line=br.readLine()) !=null){
				if(Character.isLetter(line.charAt(0))){//do nothing					
				}else{
					Scanner s = new Scanner(line);
					int year = Integer.parseInt(s.next());
					ArrayList<Double> rainData = new ArrayList<Double>();
					while(s.hasNext()){
						double data=Double.parseDouble(s.next());
						rainData.add(data);
					}
					dataMap.put(year,rainData);
					s.close();
				}
			}

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		return dataMap;
	}

	public static void wettestEvar(HashMap<Integer,ArrayList<Double>> dataMap){
		double maxRain = 0;
		int maxYear=0,maxMonth =0;
		for(ArrayList<Double> l:dataMap.values()){
			for(int i=0;i<(l.size()-1);i++){
				if(maxRain<l.get(i)){
					maxRain=l.get(i);
					maxMonth=i;
					for(Entry<Integer,ArrayList<Double>> entry:dataMap.entrySet()){
						if(entry.getValue()==l){
							maxYear=entry.getKey();
						}
				}
				}
			}
		}
		System.out.println("The wettest month was month "+maxMonth+" in the year "+maxYear+". The rainfall was "+maxRain+"mm");
		
	}
	
	public static void wettestThreeMonths(HashMap<Integer,ArrayList<Double>> dataMap){
		
	}
	public static void main(String[] args) {
		HashMap<Integer,ArrayList<Double>> data=dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2012-13/HadEWP_monthly_qc.txt");
		System.out.println(data);
		wettestEvar(data);
	}
	
	

}
