package module3;

public class TestThreeVector{
	public static void main (String[] args){
		//Produce the three ThreeVector objects
		ThreeVector v1 = new ThreeVector(5,2,3);
		ThreeVector v2 = new ThreeVector(4,5,1);
		ThreeVector v3 = new ThreeVector();

		//Print them
		System.out.println("Vector 1: "+v1.toString());
		System.out.println("Vector 2: "+v2);
		System.out.println("Vector 3: "+v3);

		try{
			//Find their unit vectors
			System.out.println("Unit Vector 1: "+v1.unitVector().toString());
			System.out.println("Unit Vector 2: "+v2.unitVector());
			System.out.println("Unit Vector 3: "+v3.unitVector());
		}catch(Exception e){
			System.out.println("Vector (0,0,0) has no defined direction, cannot create unit vector");
		}	

		//Find dot and cross products using non-static methods
		System.out.println("Using non-static methods:");
		System.out.println("V1.V2 = "+v1.dot(v2));
		System.out.println("V1.V3 = "+v1.dot(v3));
		System.out.println("V1 x V2 = "+v1.cross(v2));
		System.out.println("V1 v V3 = "+v1.cross(v3));

		//Find dot and cross products using static methods
		System.out.println("Using static methods:");
		System.out.println("V1.V2 = "+ThreeVector.dot(v1,v2));
		System.out.println("V1.V3 = "+ThreeVector.dot(v1,v3));
		System.out.println("V1 x V2 = "+ThreeVector.cross(v1,v2));
		System.out.println("V1 x V3 = "+ThreeVector.cross(v1,v3));

		//Find angles between vectors using non-static and static methods
		try{
			System.out.println("Non-static method:");
			System.out.println("The angle between V1 and V2 is: "+v1.angle(v2)+" rad");
			System.out.println(v1.angle(v3));
		}catch(Exception e){
			System.out.println("Cannot calculate angle with vector (0,0,0)");
		}
		try{
			System.out.println("Static method:");
			System.out.println("The angle between V1 and V2 is: "+ThreeVector.angle(v1,v2)+" rad");
			System.out.println(ThreeVector.angle(v1,v3));
		}catch(Exception e){
			System.out.println("Cannot calculate angle with vector (0,0,0)");
		}finally{
			System.out.println("Without a toString() method, the ThreeVector objects are printed as ThreeVector@ followed by a string of 8 characters e.g. ThreeVector@6bc7c054.\nThis is java's attempt to convert an object it does not recognise to a string.\nJava contains a default toString() function for the primitive datatypes. "
					+ "\nWhen making a new class/object, java doesn't know how to display this when printing to the screen, so we must define our own toString() method to overwrite the default. "
					+ "\nAs you can see above, I have printed the object while explicitly calling the toString function, "
					+ "\nhowever when I omit it and simply print the object, the toString function is automagically called when the program is compiled.");

		}
	}
}
