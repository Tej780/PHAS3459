package module5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DataAnalysis {

	private ArrayList<DataPoint> data;

	public ArrayList<DataPoint> dataFromURL(String url){
		try{
			URL u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String line = br.readLine();
			while(line !=null){
			DataPoint dp = DataPoint.parse(line);
			data.add(dp);
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		return data;
	}
	
	//public static double goodnessOfFit(){
		
	//}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
