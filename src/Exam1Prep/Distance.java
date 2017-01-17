package Exam1Prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Distance {
	
	//creating HashMap
		public static ArrayList<Detectors> getDist(String url){

			//instantiating key and value of the Hashmap
			String ID;
			double d;
			
			//instantiate empty Arraylist to hold each Arraylist of signals
			ArrayList<Detectors> distance = new ArrayList<Detectors>();

			//reading data from url
			URL u;
			BufferedReader br = null;
			try {
				u = new URL(url);
				InputStream is = u.openStream();
				InputStreamReader sr = new InputStreamReader(is);
				br = new BufferedReader(sr); 
				String line;
				Scanner s = null;

				while ((line = br.readLine()) != null){
					s = new Scanner(line);
					ID = String.valueOf(s.next());
					d = Double.valueOf(s.next());

					//inserting key and value into empty hashmap
					distance.add(new Detectors(ID,d)); 
				}

				//close scanner
				s.close();
			}

			catch (MalformedURLException e){
				e.printStackTrace();
			}
			catch (IOException e){
				e.printStackTrace();
			}

			//System.out.println(distance);
			return distance;
		}

}
