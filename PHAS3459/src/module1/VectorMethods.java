package module1;

public class VectorMethods {
	
	public double dotProduct(double x1, double y1, double z1,
							 double x2, double y2, double z2){
		double aDotb = x1*x2 + y1*y2 + z1*z2;
		return aDotb;
		
	}
	
	public double magnitude(double x, double y, double z){
		double mag = Math.sqrt(x*x + y*y + z*z);
		return mag;
		
	}

	public double angle(double x1, double y1, double z1,
			 			double x2, double y2, double z2){
		double aDotb = dotProduct (x1, y1, z1, x2, y2, z2);
		double magA = magnitude(x1, y1, z1);
		double magB = magnitude(x2, y2, z2);
		double cosTheta = aDotb/(magA * magB);
		double theta =  Math.toDegrees(Math.acos(cosTheta));
		return theta;
		
	}
	
	public static void main(String[] args) {
		VectorMethods vm = new VectorMethods();
		
		double x1,x2,y1,y2,z1,z2;
		x1 = 6;
		y1 = 3;
		z1 = 1;
		x2 = 2;
		y2 = 4;
		z2 = 2;
		System.out.println("Vector A is: (" + x1 + ", " + y1 + ", " + z1 + ")");
		System.out.println("Vector B is: (" + x2 + ", " + y2 + ", " + z2 + ")");
		double product = vm.dotProduct(x1,y1,z1,x2,y2,z2);
		System.out.println("The dot product of the two vectors is: " + product);
		double magA = vm.magnitude(x1, y1, z1);
		double magB = vm.magnitude(x2, y2, z2);
		System.out.println("The magnitude of Vector A is: " + magA);
		System.out.println("The magnitude of Vector B is: " + magB);
		double angle = vm.angle(x1,y1,z1,x2,y2,z2);
		System.out.println("The angle between the two vectors is: " + angle);

	}

}
