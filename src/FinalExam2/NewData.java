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

public class NewData {
	
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
					
					int year = s.nextInt();
					byte month = s.nextByte();
					byte day = s.nextByte();
					byte hour = s.nextByte();
					byte minute = s.nextByte();
					String ID = s.next();
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
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2004.txt");
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2005.txt");
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/tides-2006.txt");
		
		siteData("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2014-15/part3/sites.txt");
		
		Surge.highestSurge(tides, sites);
		
	}

}
