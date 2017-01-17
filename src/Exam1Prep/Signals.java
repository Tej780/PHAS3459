package Exam1Prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Creating ArrayList of the signals for every line of pulse in the signals text file
 * @author zcapwco
 *
 */
public class Signals {

	public static ArrayList<Pulse> getSignals(String url){

	 //instantiate empty Arraylist to hold each Arraylist of signals
		ArrayList<Pulse> pulses = new ArrayList<Pulse>();
		//amplitude Map
		ArrayList<Double> amp = new ArrayList<Double>();

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


			//iterate counter
			int counter=0;

			//scanning through each buffered reader line
			while ((line = br.readLine()) != null){	
				Scanner s = new Scanner (line);
				//count number of pulses
				counter++;			
				//initialising iterators
				double maxValue  = Double.NEGATIVE_INFINITY;
				int timer = -1;
				int arrival=0;

				//instantiate empty ArrayList to hold all the signals for each detector
				ArrayList<Double> signalPerDet = new ArrayList<Double>();

				//assign first character as the ID in String type
				String ID = s.next();

				//while there is a new character in the line
				while (s.hasNext()){		
					double x = Double.parseDouble(s.next());
					//add each signal to ArrayList of signals
					signalPerDet.add(x);
					//iterating timer variable to get the time passed
					timer++;
					
					//getting max value
					if (x > maxValue) {
					maxValue = x;	
					arrival = timer;					
					}								
					
				}					
				//System.out.println("For detector: " +ID + ", the arrival time is " + arrival +" nanoseconds and the amplitude is " +maxValue );
				amp.add(maxValue);
				//appending each data point to arraylist
			
				Pulse p = new Pulse(ID, signalPerDet,maxValue,arrival);
				System.out.println(p);
		
				pulses.add(p);
			
				//close scanner
				s.close();
			}

			System.out.println("The number of pulses is : "+counter);
			
			double mean=0;
			for(Double d:amp){
				mean+=d;
			}
			mean = mean/counter;
			System.out.println("The mean amplitude is: "+mean );

		}
		catch (MalformedURLException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return pulses;
	}	

}