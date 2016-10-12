package module2;

public class Vector{
	int x,y,z;	
	public Vector(){}
	public Vector(int a, int b, int c){
		x=a;
		y=b;	
		z=c;

}

	void getVector(){
	System.out.println("("+x+","+y+","+z+")");
}

	public double mag(){
		double magnitude = Math.sqrt(x*x + y*y + z*z);
		return magnitude;
}

	public int dot(Vector w){
		int aDotb = w.x*this.x + w.y*this.y + w.z*this.z;
		return aDotb; 	
}

	public double angle(Vector w){
		double magA = this.mag();
		double magB = w.mag();
		int aDotb = this.dot(w);
		double cosTheta = aDotb/(magA*magB);
		System.out.println(cosTheta);
		double theta = Math.toDegrees(Math.acos(cosTheta));
		return theta;
}	
	public static void main(String[] args){
	Vector w = new Vector();
	Vector v = new Vector(2,4,2);
	System.out.println(w.dot(v));
	w.getVector();
	v.getVector();
	System.out.println(v.mag());
	System.out.println(v.angle(w));
}


}
