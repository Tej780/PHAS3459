package module4;
import java.util.Scanner;
import java.io.*;
import java.net.*;
public class WordCounter{
	public static BufferedReader brFromURL(String urlName){
	BufferedReader br = null;
	try{
		URL u = new URL(urlName);
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

	public static BufferedReader brFromFile(String fileName){
		BufferedReader br = null;
		try{
		FileReader fr = new FileReader(fileName);
		br = new BufferedReader(fr);
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
		return br;
}

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
			br = brFromURL(file);
			x++;
			
		}else{
			System.out.println("Unnacceptable input, please try again");
		}}while(x==0);
		System.out.println("The total number of words in this resource: " +countWordsInResource(br));
		s.close();
		}


}
