package module2;

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
		//Find their unit vectors
		System.out.println("Unit Vector 1: "+v1.unitVector().toString());
        	System.out.println("Unit Vector 2: "+v2.unitVector());
        	System.out.println("Unit Vector 3: "+v3.unitVector());
        	//Find dot and cross products using non-static methods
		System.out.println("Using non-static methods:");
		System.out.println("V1.V2 = "+v1.dot(v2));
		System.out.println("V1.V3 = "+v1.dot(v3));
		System.out.println("V1 x V2 = "+v1.cross(v2));
		System.out.println("V1 v V3 = "+v1.cross(v3));
		//Find dot and cross products using static methods
		System.out.println("Using static methods:");
		System.out.println("V1.V2 = "+ThreeVector.Dot(v1,v2));
		System.out.println("V1.V3 = "+ThreeVector.Dot(v1,v3));
        	System.out.println("V1 x V2 = "+ThreeVector.Cross(v1,v2));
        	System.out.println("V1 x V3 = "+ThreeVector.Cross(v1,v3));
        	//Find angles between vectors using non-static and static methods
		System.out.println("Non-static method:");
		System.out.println("The angle between V1 and V2 is: "+v1.angle(v2)+" rad");
		System.out.println(v1.angle(v3));
		System.out.println("Static method:");
		System.out.println("The angle between V1 and V2 is: "+ThreeVector.Angle(v1,v2)+" rad");
		System.out.println(ThreeVector.Angle(v1,v3));
		System.out.println("Without a toString() method, the ThreeVector objects are printed as ThreeVector@ followed by a string of 8 characters e.g. ThreeVector@6bc7c054. This is java's attempt to convert an object it does not recognise to a string. Java contains a default toString() function for the primitive datatypes. When making a new class/object, java doesn't know how to display this when printing to the screen, so we must define our own toString() method to overwrite the default. As you can see above, I have printed the object while explicitly calling the toString function, however when I omit it and simply print the object, the toString function is automagically called when the program is compiled.");

}
}
