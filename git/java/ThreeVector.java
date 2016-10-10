public class ThreeVector{
	double x,y,z;
        public ThreeVector(){}
        public ThreeVector(double a, double b, double c){
                x=a;
                y=b;
                z=c;

}
        public ThreeVector unitVector(){
                double ux = this.x/this.mag();
                double uy = this.y/this.mag();
                double uz = this.z/this.mag();
                ThreeVector u = new ThreeVector(ux, uy, uz);
                return u;
}

        public String toString(){
        String vector = ("("+this.x+","+this.y+","+this.z+")");
	return vector;
}

        public double mag(){
                double magnitude = Math.sqrt(x*x + y*y + z*z);
                return magnitude;
}

        public double dot(ThreeVector w){
                double aDotb = w.x*this.x + w.y*this.y + w.z*this.z;
                return aDotb;
}

        public double angle(ThreeVector w){
                double magA = this.mag();
                double magB = w.mag();
                double aDotb = this.dot(w);
                double cosTheta = aDotb/(magA*magB);
                System.out.println(cosTheta);
                double theta = Math.toDegrees(Math.acos(cosTheta));
                return theta;
}

	public ThreeVector cross(ThreeVector w){
		double a = this.y*w.z - w.y*this.z;
		double b = this.z*w.x - w.z*this.x;
		double c = this.x*w.y - w.x*this.y;
		ThreeVector x = new ThreeVector(a,b,c);
		return x; 
}

	public ThreeVector add(ThreeVector w){
		double x = this.x + w.x;
		double y = this.y + w.y;
		double z = this.z + w.z;
		ThreeVector add = new ThreeVector(x,y,z);
		return add;
} 

        public static void main(String[] args){
        ThreeVector w = new ThreeVector(6,3,1);
        ThreeVector v = new ThreeVector(2,4,2);
        System.out.println(w.dot(v));
	System.out.println(v.toString());
        System.out.println(v.mag());
        System.out.println(v.angle(w));
	System.out.println(v.unitVector());
	System.out.println(v.cross(w));
	System.out.println(v.add(w));
	System.out.println(ThreeVector.Cross(v,w));
        System.out.println(ThreeVector.Add(v,w));

}

	public static double Dot(ThreeVector v, ThreeVector w){
		double vDotw = v.x*w.x + v.y*w.y + v.z*w.z;
		return vDotw;
}

	public static ThreeVector Cross(ThreeVector v, ThreeVector w){
		double a = v.y*w.z - w.y*v.z;
                double b = v.z*w.x - w.z*v.x;
                double c = v.x*w.y - w.x*v.y;
                ThreeVector x = new ThreeVector(a,b,c);
                return x;
} 

	public static ThreeVector Add(ThreeVector v, ThreeVector w){
		double x = v.x + w.x;
                double y = v.y + w.y;
                double z = v.z + w.z;
                ThreeVector add = new ThreeVector(x,y,z);
                return add;

}

	public static double Angle(ThreeVector v, ThreeVector w){
		double magA = v.mag();
                double magB = w.mag();
                double aDotb = v.dot(w);
                double cosTheta = aDotb/(magA*magB);
                System.out.println(cosTheta);
                double theta = Math.toDegrees(Math.acos(cosTheta));
                return theta;

}


}
