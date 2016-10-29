package module4;
import java.util.Scanner;
import java.io.*;
import java.net.*;
public class WordCounter{

	/**Creates a BufferedReader object based on a file found at a given URL
	 * @param urlName
	 * @return
	 */
	public static BufferedReader brFromURL(String urlName){
		BufferedReader br = null;
		try{
			//creates an abstract URL object based off the input string
			URL u = new URL(urlName);
			//opens an input stream connection to the URL
			InputStream is = u.openStream();
			//reads the bytes from the input stream and decodes them as characters (bytestream -> characterstream)
			InputStreamReader isr = new InputStreamReader(is);
			//reads characters from character stream
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

	/**Creates a BufferedReader object based on a file found at a given file location
	 * @param fileName
	 * @return
	 */
	public static BufferedReader brFromFile(String fileName){
		BufferedReader br = null;
		try{
			//abstract representation of the file stored at the given directory string
			File f = new File(fileName);
			//enables reading the character file
			FileReader fr = new FileReader(f);
			//stores files within a BufferedReader object
			br = new BufferedReader(fr);
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
		return br;
	}

	/**Returns the number of words (strings of characters separated by whitespace) stored within the BufferedReader
	 * @param dataAsBR
	 * @return
	 */
	public static int countWordsInResource(BufferedReader dataAsBR){
		int counter = 0;
		try(
				Scanner s = new Scanner(dataAsBR);
				){
			while(s.hasNext()){
				s.next();
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		System.out.println("Are you using a (f)ile or (u)rl?");
		BufferedReader br=null;
		int x=0;
		do{
			String type = s.next();
			if (type.charAt(0)=='u'){
				System.out.println("Please enter the URL");
				String URL = s.next();
				br = brFromURL(URL);
				x++;
			}else if(type.charAt(0)=='f'){
				System.out.println("Please enter the File Name");
				String file = s.next();
				br = brFromFile(file);
				x++;

			}else{
				System.out.println("Unnacceptable input, please try again");
			}}while(x==0);
		System.out.println("The total number of words in this resource: " +countWordsInResource(br));
		s.close();
	}


}
