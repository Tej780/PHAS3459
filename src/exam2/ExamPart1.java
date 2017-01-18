package exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExamPart1 {

	//Create member variables to store the audio and file data
	static HashMap<String,String> index = new HashMap<String,String>();
	static ArrayList<Audio> audio = new ArrayList<Audio>();

	public static void main(String[] args) {
		//get data from index file
		indexdata("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");
		//get Audio data and make the Arraylist
		audiodata();

		for(Audio a:audio){
			System.out.println("File name: "+a.filename);
			double duration = (a.sampleNo)/a.sampleFreq;
			System.out.println("Duration: "+duration+" s");

			//calculate Root Mean Square of amplitude data
			double square=0;
			for(double i :a.amplitude){
				square+=(i*i);
			}
			double meanSquare = square/a.sampleNo;
			double RMS = Math.sqrt(meanSquare);

			//convert amplitude data to dBFS
			double A = 20*(Math.log10(RMS/a.aMax));
			System.out.println("Amplitude of signal in dBFS: "+A);
			System.out.println("Instrument: "+a.instrument+"\n");

		}	
	}

	/**
	 * Gets audio data from the given URL and turns it into an Audio object before adding it to the Audio ArrayList
	 */
	protected static void audiodata() {
		Audio A=instrumentDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genA.txt");
		Audio B=instrumentDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genB.txt");
		Audio C=instrumentDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/genC.txt");
		Audio One = instrumentDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording01.txt");
		Audio Two = instrumentDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording02.txt");
		Audio Three = instrumentDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording03.txt");
		Audio Four = instrumentDataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/recording04.txt");
		audio.add(A);
		audio.add(B);
		audio.add(C);
		audio.add(One);
		audio.add(Two);
		audio.add(Three);
		audio.add(Four);
	}

	/**
	 * Gets the index data for the instruments and their respective files
	 */
	public static void indexdata(String url){

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

				while(s.hasNext()){
					String filename = s.next();
					String instrument = s.next();
					//add data to HashMap using the name of the file as the Key
					index.put(filename,instrument);		
				}
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



	/**
	 * Gets the audio data from a particular file and creates and returns Audio object
	 * @param url
	 * @return Audio object
	 */
	public static Audio instrumentDataFromURL(String url){

		Audio a = null;
		//gets the end of the url as this is the filename for the instrument
		String filename=url.split("/")[(url.split("/").length-1)];
		//finds the instrument, corresponding to the file, from the index
		String instrument = index.get(filename);

		try {
			//reading url data
			URL u;
			BufferedReader br = null;
			u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader sr = new InputStreamReader(is);
			br = new BufferedReader(sr);						

			//variables representing the member variables of the Audio object
			double sFreq=0;//sample frequency
			double sNum=0;//number of samples
			double aMax=0;//maximum amplitude
			ArrayList<Integer> amp = new ArrayList<Integer>();//array of integers representing the amplitude
			//breaking buffered reader into lines to be scanned for analysis 
			
			//gets the data for the member variables from the very first line of the file
			String line=br.readLine();
			Scanner s = new Scanner(line);
			while(s.hasNext()){
				sFreq=s.nextInt();
				sNum=s.nextInt();
				aMax=s.nextInt();
			}

			//gets the amplitude data for the Arraylist from every subsequent line
			//scanning through each buffered reader line
			while ((line = br.readLine()) != null){	
				s = new Scanner (line);
				while(s.hasNext()){
					amp.add(s.nextInt());
				}


				//close scanner to prevent leaking
				s.close();
			}
			//make Audio object
			a = new Audio(instrument,filename, sFreq,sNum,aMax,amp);
		}
		catch (MalformedURLException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return a;	
	}		
}
