package FinalExam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TidalData {
	
	static ArrayList<Tides> tides = new ArrayList<Tides>();
	static HashMap<String,String> sites = new HashMap<String, String>();
	
	public static void dataFromURL(String url){

		 //instantiate empty Arraylist
			
			try {
				//reading url data
				URL u;
				BufferedReader br = null;
				u = new URL(url);
				InputStream is = u.openStream();
				InputStreamReader sr = new InputStreamReader(is);
				br = new BufferedReader(sr);						

				//breaking buffered reader into lines to be scanned for analysis 
				String line="";

				//scanning through each buffered reader line
				while ((line = br.readLine()) != null){	
					Scanner s = new Scanner (line);
		
					//assign first character as the ID in String type
					String ID = s.next();
					int year = s.nextInt();
					byte month = s.nextByte();
					byte day = s.nextByte();
					byte hour = s.nextByte();
					byte minute = s.nextByte();
					double seaLevel = s.nextDouble();
					double predictedLevel=s.nextDouble();
					
					Tides t = new Tides(ID,year,month,day,hour,minute,seaLevel,predictedLevel);
						
					tides.add(t);					

					//close scanner
					s.close();
				}

				
			}
			catch (MalformedURLException e){
				e.printStackTrace();
			}
			catch (IOException e){
				e.printStackTrace();
			}
			
		}	
	
	public static void siteData(String url){
		try {
			//reading url data
			URL u;
			BufferedReader br = null;
			u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader sr = new InputStreamReader(is);
			br = new BufferedReader(sr);						

			//breaking buffered reader into lines to be scanned for analysis 
			String line="";
			//skip first line
			br.readLine();
			//scanning through each buffered reader line
			while ((line = br.readLine()) != null){	
				Scanner s = new Scanner (line);
	
				String name = s.next();
				String ID = s.next();
				sites.put(ID,name);
				//close scanner
				s.close();
			}

			
		}
		catch (MalformedURLException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-1999.txt");
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2000.txt");
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/tides-2001.txt");
		
		siteData("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/sites.txt");
		highest();
		
		System.out.println("");
		Mean m = new Mean();
		m.average(tides, sites);
		System.out.println("");
		Range r = new Range();
		r.average(tides,sites);
		System.out.println("");
		Surge.highestSurge(tides, sites);
		
	}
	
	public static void highest(){
		double highTide = Double.NEGATIVE_INFINITY;
		String id = "";
		String date = "";
		String time = "";
		for(Tides t:tides){
			if(t.seaLevel>highTide){
				highTide=t.seaLevel;
				id=t.ID;
				date= t.day+"/"+t.month+"/"+t.year;
				time= t.hour+":"+t.minute;
			}
		}
		
		String highName=sites.get(id);
		
		System.out.println("The highest level is "+ highTide);
		System.out.println("The name and ID of the highest level is: "+ highName+", "+id);
		System.out.println("The highest level occured on "+date+" at "+time);
		
		
		
	}

}
