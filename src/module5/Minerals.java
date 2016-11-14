package module5;

//import classes for importing data from URL
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
//Import classes for HashMaps
import java.util.*;
import java.util.Map.Entry;

public class Minerals {
	//produce member variables to store the data from the two url's
	private static HashMap<String,String> mass = new HashMap<String,String>();
	private static HashMap<String,String> loc = new HashMap<String,String>();

	/**
	 * Gets data from the given URL, and input it into a HashMap
	 * @param url
	 * @param hash
	 */
	public static void dataToHash(String url,HashMap<String,String> hash){
		try{
			//pull data from url
			URL u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line="";
			//take data line by line and put the key and value into the HashMap
			while((line = br.readLine())!=null){
				String sampleData[] = line.split("  ");
				//for the location file, swap the columns to ensure the sample key is used as the HashMap key
				//Could have produced 3 arrays (location, key and mass) and then built the HashMaps. Don't know which method is preferred.
				if(Character.isLetter(sampleData[0].charAt(0))){
					String s = sampleData[0];

					sampleData[0]=sampleData[1];
					sampleData[1]=s;
				}
				hash.put(sampleData[0],sampleData[1]);
			}
			/*
			 *for exception handling, I wasn't sure if any needed to be added here since we are building the program around the data		
			 *for a very specific use case i.e. the data files have been set up to just "work" with the program. Decided to leave any extra
			 *potential exceptions out in this case
			 */
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
	}

	//could have made more methods to shrink the main method, but none of the code is repeated per se, so decided it was more efficient this way
	//if java could return multiple values (without the use of arrays/collections), I might have changed my mind
	public static void main(String[] args) {
		dataToHash("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt", mass);
		//produce array of masses
		double[] masses = new double[mass.size()];
		int i = 0;
		for (String x:mass.values()){
			double massValue = Double.parseDouble(x);
			masses[i]=massValue;
			i++;
		}
		//find min and max mass from array of masses
		double minMass = masses[0];
		double maxMass = masses[0];
		for(i=0;i<masses.length;i++){
			if(masses[i]<minMass){
				minMass = masses[i];
			}else if(masses[i]>maxMass){
				maxMass = masses[i];
			}

		}

		//find the key for the minimum and maximum mass. Could have made string arrays in case multiple keys found, but considering the problem
		//this seemed unlikely (unlikely to get identical masses)
		String maxMassKey="";
		String minMassKey="";

		for(Entry<String, String> entry: mass.entrySet()){//takes every entry in order to compare masses
			if(Double.parseDouble(entry.getValue())==maxMass){
				maxMassKey=entry.getKey();
			}else if(Double.parseDouble(entry.getValue())==minMass){
				minMassKey=entry.getKey();
			}
		}

		//given key and mass, find and print corresponding location
		dataToHash("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt",loc);
		System.out.println("Key: "+maxMassKey+", Maximum mass:"+maxMass+", Location:"+loc.get(maxMassKey));
		System.out.println("Key: "+minMassKey+", Minimum mass:"+minMass+", Location:"+loc.get(minMassKey));
	}

}
