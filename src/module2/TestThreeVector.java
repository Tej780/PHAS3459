public class TestThreeVector{
	public static void main (String[] args){
		ThreeVector v1 = new ThreeVector(5,2,3);
		ThreeVector v2 = new ThreeVector(4,5,1);
		ThreeVector v3 = new ThreeVector();
		System.out.println(v1.toString());
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v1.unitVector().toString());
                System.out.println(v2.unitVector());
                System.out.println(v3.unitVector());
		System.out.println(v1.dot(v2));
		System.out.println(v1.dot(v3));
		System.out.println(v1.cross(v2));
		System.out.println(v1.cross(v3));
		System.out.println(ThreeVector.Dot(v1,v2));
		System.out.println(ThreeVector.Dot(v1,v3));
                System.out.println(ThreeVector.Cross(v1,v2));
                System.out.println(ThreeVector.Cross(v1,v3));
		System.out.println(v1.angle(v2));
		System.out.println(v1.angle(v3));
		System.out.println(ThreeVector.Angle(v1,v2));
		System.out.println(ThreeVector.Angle(v1,v3));
		System.out.println(v1);
		System.out.println("Without a toString() method, the ThreeVector objects are printed as ThreeVector@ followed by a string of 8 characters e.g. ThreeVector@6bc7c054. This is java's attempt to convert an object it does not recognise to a string. Java contains a default toString() function for the default datatypes. When making a new class/object, java doesn't know how to display this when printing to the screen, so we must define our own toString() method to overwrite the default. As you can see above, I have printed the object while explicitly calling the toString function, however when I omit it and simply print the object, the toString function is automagically called when the program is compiled.");


}
}
