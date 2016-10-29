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
		minValue=10^99;
		maxValue=0;
		nValues=0;
		sumOfValues=0;
		FileWriter fw = null;
		try{
			File outputFile = new File(dataFile);
			fw = new FileWriter(outputFile);

		}catch(IOException e){
			System.out.println(e);
		}
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
	}

	public void analyseData(String line){
		if(line.trim().isEmpty() || line.startsWith("x") || line.startsWith("c")){
		}else {

			String[] parts = line.split("\t|     | ");
			for (int i=0;i<parts.length;i++){
				double value = Double.parseDouble(parts[i]);
				System.out.println(value);
				sumOfValues += value;
				nValues++;
				if(value<minValue){

					minValue = value;
				}else if(value>maxValue){

					maxValue = value;

				}
			}
		}
	}


	public void analysisEnd(){
		System.out.println("Minimum value: "+minValue);
		System.out.println("Maximum value: "+maxValue);
		System.out.println("Number of datapoints: "+nValues);
		System.out.println("Average: "+sumOfValues/nValues);
	}

	public static void main(String[] args){
		String dataFile1 = "numbers1.txt";
		String dataFile2 = "numbers2.txt";
		String location = NumericalReader.getStringFromKeyboard();
		String saveFile1 = location + File.separator + dataFile1;
		String saveFile2 = location + File.separator + dataFile2;
		NumericalReader nr1 = new NumericalReader();
		BufferedReader br1 = nr1.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data1.txt");
		String line = "";
		nr1.analysisStart(saveFile1);
		try{
			while((line = br1.readLine()) != null){
				nr1.analyseData(line);

			}
		}catch(IOException e){
			System.out.println(e);
		}
		nr1.analysisEnd();

		NumericalReader nr2 = new NumericalReader();
		BufferedReader br2 = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
		line = "";
		nr1.analysisStart(saveFile2);
		try{
			while((line = br2.readLine()) != null){
				line.split("\\t");
				nr2.analyseData(line);

			}
		}catch(IOException e){
			System.out.println(e);
		}
		nr2.analysisEnd();


	}
}
