package module3;
public class ThreeVector{

	private double x,y,z;//represents the components of the vector to be stored by the object
	public ThreeVector(){}
	public ThreeVector(double x1, double x2, double x3){//represents the components of the vector passed in by the object creator
		x=x1;
		y=x2;
		z=x3;

	}	

	/**                                                    
	 * Returns the magnitude of the given vector
	 * @return magnitude
	 */
	public double mag(){
		double magnitude = Math.sqrt(x*x + y*y + z*z);
		return magnitude;
	}

	/**
	 * Produces a unit vector object in the same direction as the original vector
	 * @return Unit Vector
	 */
	public ThreeVector unitVector() throws Exception{
		ThreeVector u = new ThreeVector();	
		if(this.mag() == 0){//prevents the program from attempting to produce a unit vector of the null vector (0,0,0)
			throw new Exception();
		}
		double mag = this.mag();
		double ux = this.x/mag;
		double uy = this.y/mag;
		double uz = this.z/mag;
		u = new ThreeVector(ux, uy, uz);
		return u;
	}

	/**
	 * Facilitates the printing of the vector object
	 * @return Vector as text string
	 */
	public String toString(){
		String vector = ("("+this.x+","+this.y+","+this.z+")");
		return vector;
	}

	/**
	 * Calculates the scalar (dot) product of two given vectors
	 * 
	 * @param v vector 1
	 * @param w vector 2
	 * @return Product
	 */
	public static double dot(ThreeVector v, ThreeVector w){
		double vDotw = v.x*w.x + v.y*w.y + v.z*w.z;
		return vDotw;
	}
	public double dot(ThreeVector w){//can use static and non static versions of these methods
		double aDotb = ThreeVector.dot(this,w);
		return aDotb;
	}

	/**                                                           
	 * Calculates the vector (cross) product of two given vectors
	 * @param v vector 1
	 * @param w vector 2
	 * @return Vector
	 */
	public static ThreeVector cross(ThreeVector v, ThreeVector w){
		double a = v.y*w.z - w.y*v.z;
		double b = v.z*w.x - w.z*v.x;
		double c = v.x*w.y - w.x*v.y;
		ThreeVector x = new ThreeVector(a,b,c);
		return x;
	}
	public ThreeVector cross(ThreeVector w){
		ThreeVector x = ThreeVector.cross(this,w);
		return x; 
	}

	/**                                                         
	 * Adds two vectors together
	 * @param v vector 1
	 * @param w vector 2
	 * @return Vector
	 */
	public static ThreeVector add(ThreeVector v, ThreeVector w){
		double x = v.x + w.x;
		double y = v.y + w.y;
		double z = v.z + w.z;
		ThreeVector add = new ThreeVector(x,y,z);
		return add;

	}
	public ThreeVector add(ThreeVector w){
		ThreeVector add = ThreeVector.add(this,w);
		return add;
	} 

	/**
	 * Calculates the angle between two vectors
	 * @param v vector 1
	 * @param w vector 2
	 * @return Angle
	 */
	public static double angle(ThreeVector v, ThreeVector w) throws Exception{
		double magA = v.mag();
		double magB = w.mag();
		if(magA==0 || magB==0){//as before, if either vector is the null vector, the angle is undefined so the program must be prevented from attempting this calculation
			throw new Exception();}
		double aDotb = v.dot(w);
		double cosTheta = aDotb/(magA*magB);
		double theta = Math.acos(cosTheta);//the angle should be in radians by default
		return theta;
	}					
	public double angle(ThreeVector w) throws Exception{
		double theta = ThreeVector.angle(this,w);
		return theta;
	}

	/*
        public static void main(String[] args){
        	ThreeVector w  = new ThreeVector(6,3,1);
        	ThreeVector v = new ThreeVector(2,4,2);
		ThreeVector Null2 = new ThreeVector();
        	System.out.println(w.dot(v));
        	System.out.println(v.toString());
        	System.out.println(v.mag());
        	System.out.println(v.angle(w));
        	System.out.println(v.unitVector());
        	System.out.println(v.cross(w));
        	System.out.println(v.add(w));
        	System.out.println(ThreeVector.Cross(v,w));
        	System.out.println(ThreeVector.Add(v,w));
		System.out.println(Null2.unitVector());
		System.out.println(Null2.angle(w));
					      }*/
}
