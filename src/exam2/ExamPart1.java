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


	static HashMap<String,String> index = new HashMap<String,String>();
	static ArrayList<Audio> audio = new ArrayList<Audio>();

	public static void main(String[] args) {
		indexdata("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");
		audiodata();

		for(Audio a:audio){
			System.out.println("File name: "+a.filename);
			double duration = (a.sampleNo)/a.sampleFreq;
			System.out.println("Duration: "+duration+" s");

			int square=0;
			for(int i :a.amplitude){
				square+=(i*i);
			}
			double meanSquare = square/a.sampleNo;
			double RMS = Math.sqrt(meanSquare);

			double A = 20*(Math.log10(RMS/a.aMax));
			System.out.println("Amplitude of signal in dBFS: "+A);
			System.out.println("Instrument: "+a.instrument+"\n");

		}	
	}

	private static void audiodata() {
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

				//assign first character as the ID in String type
				while(s.hasNext()){
					String filename = s.next();
					String instrument = s.next();

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



	public static Audio instrumentDataFromURL(String url){

		Audio a = null;
		String filename=url.split("/")[(url.split("/").length-1)];
		String instrument = index.get(filename);

		try {
			//reading url data
			URL u;
			BufferedReader br = null;
			u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader sr = new InputStreamReader(is);
			br = new BufferedReader(sr);						

			int sFreq=0;
			int sNum=0;
			int aMax=0;
			ArrayList<Integer> amp = new ArrayList<Integer>();
			//breaking buffered reader into lines to be scanned for analysis 
			String line=br.readLine();
			Scanner s = new Scanner(line);
			while(s.hasNext()){
				sFreq=s.nextInt();
				sNum=s.nextInt();
				aMax=s.nextInt();
			}


			//scanning through each buffered reader line
			while ((line = br.readLine()) != null){	
				s = new Scanner (line);
				while(s.hasNext()){
					amp.add(s.nextInt());
				}


				//close scanner
				s.close();
			}

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
