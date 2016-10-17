package module3;
import java.util.Random;
import java.lang.Integer;
import java.lang.Math;
import java.lang.Character;
import java.lang.StringBuilder;
public class Alphabet{

	public static char randomCharacter(){
		Random rand = new Random();
		int randInt = rand.nextInt(127);
		char randomChar = (char)(randInt);
		return randomChar;
					    }



	public static void main (String[] args){
		StringBuilder s = new StringBuilder();
		char randChar = randomCharacter();
		int total = 0;
		int exceptions = 0;
		for (int i=0;i<400;i++){
			System.out.println(i);	
			if(Character.isLetterOrDigit(randChar)){
				s.append(randChar);
				try{
					total+=Integer.parseInt((Character.toString(randChar)));}
				catch(Exception e){
					exceptions++;
					}
								}
			randChar =  randomCharacter();
								}	
		System.out.println(s);
		System.out.println(total);
		System.out.println(exceptions);
					}
						}	
