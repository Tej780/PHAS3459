package module3;
import java.util.Random;
import java.lang.Integer;
import java.lang.Character;
import java.lang.StringBuilder;
public class Alphabet{

	/**
	 * Produces a random integer between 0 and 127, and finds the corresponding ASCII character
	 * @return The random character
	 */
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
				//if the character is a letter or digit, append it to the stringBuilder object
				s.append(randChar);
				try{
					//if the character is an integer, parse it to allow us to use it in a calculation. Add its value to total.
					total+=Integer.parseInt((Character.toString(randChar)));}
				catch(Exception e){
					//count the number of exceptions thrown
					exceptions++;
					}
								}
			//reroll the random character
			randChar =  randomCharacter();
								}	
		System.out.println(s);
		System.out.println(total);
		System.out.println(exceptions);
					}
						}	
