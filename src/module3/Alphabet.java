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
		double total = 0;
		double exceptions = 0;
		double strnum = 0;
		for (int i=0;i<400;i++){	
			if(Character.isLetterOrDigit(randChar)){
				//if the character is a letter or digit, append it to the stringBuilder object
				s.append(randChar);
				strnum++;
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
		System.out.println("The total number of characters in the string is: "+ strnum);
		System.out.println("Sum of all integer characters: "+total);
		System.out.println("Total number of exceptions thrown: "+exceptions);
		System.out.println("\nThe following is because I am bored");
		System.out.println("The total number of integers in the string is: "+(strnum-exceptions));
		double average = total/(strnum-exceptions);
		System.out.println("The average value of integers is: "+ average);
		System.out.println("Considering the expectation value for the average is 4.5,"
				+ "\nthis shows that the 'random' aspect of the random character is sufficiently random when using a high loop number (like 400000),"
				+ "\nand not skewed (or at least not skewed enough for us to notice with this basic test)."
				+ "\nAt 400 loops there is much more variation on the average, and it does seem to slightly favour the lower numbers (i.e. the average seems to show up closer to 3.5 than 5.5)");
	}
}	
