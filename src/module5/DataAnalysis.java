package module5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DataAnalysis {

	private static ArrayList<DataPoint> data;

	public static void dataFromURL(String url){
		try{
			URL u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line = br.readLine();

			while(line !=null){
				Scanner s = new Scanner(line);
				while(s.hasNext()){
					String dataString = s.next();
					DataPoint dp = DataPoint.parse(dataString);
					data.add(dp);
				}
				s.close();
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}

	//public static double goodnessOfFit(){

	//}

	public static void main(String[] args) {
		dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
		for(int i = 0;i<data.size();i++){
			System.out.println(data.get(i));

		}

	}

}
