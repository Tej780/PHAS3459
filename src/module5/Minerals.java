package module5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class Minerals {

	private static HashMap<String,String> mass = new HashMap<String,String>();
	private static HashMap<String,String> loc = new HashMap<String,String>();
	
	public static void dataToHash(String url,HashMap<String,String> hash){
		try{
			URL u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line="";
			while((line = br.readLine())!=null){
				String sampleData[] = line.split("  ");
				System.out.println(sampleData[1]);
				hash.put(sampleData[0],sampleData[1]);
			}

			
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		dataToHash("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt", mass);
		dataToHash("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt",loc);
		
		
	}

}
