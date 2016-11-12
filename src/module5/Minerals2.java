package module5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

public class Minerals2 {

	//produce member variables to store the data from the two url's
		private static HashMap<String,String> mass = new HashMap<String,String>();
		private static HashMap<String,String> loc = new HashMap<String,String>();

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

			for(Entry<String, String> entry: mass.entrySet()){
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
