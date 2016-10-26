package module4;
import java.util.Scanner;
import java.lang.Double;
import java.io.*;
import java.net.*;
public class NumericalReader{

	public NumericalReader(){}

	private static double minValue, maxValue,sumOfValues;
	private static int nValues;

	public static String getStringFromKeyboard(){
		Scanner s = new Scanner (System.in);
		System.out.println("Enter the location to store the datafile:");
		String input = s.next();
		s.close();
		return input;
	}

	public BufferedReader brFromURL(String url){
		BufferedReader br = null;
		try{
			URL u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);

		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		return br;
	}

	public void analysisStart(String dataFile){
		minValue=0;
		maxValue=0;
		nValues=0;
		sumOfValues=0;
		try{
			FileWriter f = new FileWriter(dataFile);
			BufferedWriter bw = new BufferedWriter(f);
			PrintWriter pw = new PrintWriter(bw);
		}catch(IOException e){
			System.out.println(e);
		}
	}

	public void analyseData(String line){
		if(line.trim().isEmpty() || line.startsWith("x") || line.startsWith("c")){
		}else {
	
			String[] parts = line.split("\t|     | ");
			System.out.println("length"+parts.length);
			double[] values = new double[parts.length];
			for (int i=0;i<parts.length;i++){
				double value = Double.parseDouble(parts[i]);
				sumOfValues += value;
				nValues++;
				
				values[i]=value;
				System.out.println(values[i]);
				}
			
			double max=1;
			double min = 2;
			for (int i = 0;i<values.length-1;i++){
				//System.out.println(values[i]);
				if(values[i+1]<=values[i]){
					min = values[i+1];
				}else if(values[i+1]>=values[i]){
					max = values[i+1];
				}
			}
			minValue = min;
			maxValue = max;
		}
	}


	public void analysisEnd(){
		System.out.println("Minimum value: "+minValue);
		System.out.println("Maximum value: "+maxValue);
		System.out.println("Number of datapoints: "+nValues);
		System.out.println("Sum of values: "+sumOfValues);
	}

	public static void main(String[] args){
		String dataFile = "N:"+ File.separator+"mywork"+File.separator+"number.txt";
		File outputfile = new File(dataFile);
		try{
			FileWriter fw = new FileWriter(outputfile);
		}catch(IOException e){
			System.out.println(e);
		}
		String location = NumericalReader.getStringFromKeyboard();
		String savefile = location + File.separator + dataFile;
		NumericalReader nr = new NumericalReader();
		BufferedReader br = nr.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
		String line = "";
		nr.analysisStart(savefile);
		try{
			while((line = br.readLine()) != null){
				line.split("\\t");
				nr.analyseData(line);
				
			}
		}catch(IOException e){
			System.out.println(e);
		}
		nr.analysisEnd();
	}
}
