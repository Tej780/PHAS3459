package module4;
import java.util.Scanner;
import java.lang.Double;
import java.io.*;
import java.net.*;

public class NumericalReader{

	public NumericalReader(){}

	//declare member variables
	private static double minValue, maxValue,sumOfValues;
	private static int nValues;
	FileWriter fw = null;
	BufferedWriter bw = null;	
	PrintWriter pw = null;
	
	/**Allows the user to specify the directory in which to store the data files
	 * @return input, the string entered by the user to represent to directory
	 */
	public static String getStringFromKeyboard(){
		Scanner s = new Scanner (System.in);
		System.out.println("Enter the location to store the datafile:");
		String input = s.next();
		s.close();
		return input;
	}

	/**Stores the character file found at the given URL within the BufferedReader
	 * @param url, a string representing the URL that points to the data file
	 * @return br, the BufferedReader object holding the data stored at the given URL
	 */
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

	/**Initialize the variables for analyzing the data, and creates the file to store the analyzed data
	 * @param dataFile, string containing the location at which the file will be stored
	 */
	public void analysisStart(String dataFile){
		minValue=10^99;
		maxValue=0;
		nValues=0;
		sumOfValues=0;
		try{
			File outputFile = new File(dataFile);
			fw = new FileWriter(outputFile);

		}catch(IOException e){
			System.out.println(e);
		}
	}

	/**Finds each individual number, prints it to both the console and data file. 
	 * Finds the max, min, average and total number of data points
	 * @param line, takes each line of the data file one by one for analysis
	 */
	public void analyseData(String line){
		if(line.trim().isEmpty() || Character.isLetter(line.charAt(0))){
			//do nothing
		}else {
			Scanner s = new Scanner(line);
			while(s.hasNext()){
				String data = s.next();
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
				//print data to data file
				pw.println(data);
				pw.flush();
				//turn data string into double for use in calculations
				double value = Double.parseDouble(data);
				System.out.println(value);
				sumOfValues += value;
				nValues++;
				if(value<minValue){
					minValue = value;
				}else if(value>maxValue){
					maxValue = value;
				}
				
			}
			s.close();
		}
	}


	/**Print out results of data analysis and close all write streams
	 * 
	 */
	public void analysisEnd(){
		System.out.println("Minimum value: "+minValue);
		System.out.println("Maximum value: "+maxValue);
		System.out.println("Number of datapoints: "+nValues);
		System.out.println("Average: "+sumOfValues/nValues);

		try {
			fw.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.close();
	}

	public static void main(String[] args){
		//Choose where to store the two data files
		String dataFile1 = "numbers1.txt";
		String dataFile2 = "numbers2.txt";
		String location = NumericalReader.getStringFromKeyboard();
		String saveFile1 = location + File.separator + dataFile1;
		String saveFile2 = location + File.separator + dataFile2;
		
		//Analyze data from first URL
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

		//Analyse data from second URL
		NumericalReader nr2 = new NumericalReader();
		BufferedReader br2 = nr2.brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_data2.txt");
		line = "";
		nr2.analysisStart(saveFile2);
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
