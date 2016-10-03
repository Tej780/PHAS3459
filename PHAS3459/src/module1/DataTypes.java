package module1;

public class DataTypes {

	public static void main(String[] args) {
		//investigating data types, module assignment and printing
		double doubVar = 20;
		System.out.println(doubVar);
		System.out.println(doubVar*doubVar);
		float floatVar = 20;
		System.out.println(floatVar);
		System.out.println(floatVar*floatVar);
		int intVar = 20;
		System.out.println(intVar);
		System.out.println(intVar*intVar);
		long longVar = 20;
		System.out.println(longVar);
		System.out.println(longVar*longVar);
		byte byteVar = 20;
		System.out.println(byteVar);
		System.out.println(byteVar*byteVar);
		
		
		char charVar = 'a' + 10;
		System.out.println(charVar);
		System.out.println(charVar * 10);
		System.out.println("String" + 10 );
		
		
		/*
		int j =1;
		int i;
		j = i + 1;
		*/
		
		
		double doubleCast = 12.99;
		int intCast = 0;
		intCast = (int) doubleCast;
		System.out.println(intCast);
		
	}

}
