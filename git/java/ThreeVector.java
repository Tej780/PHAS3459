public class ThreeVector{
	double x,y,z;
        public ThreeVector(){}
        public ThreeVector(double a, double b, double c){
                x=a;
                y=b;
                z=c;

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

	public ThreeVector unitVector(){
		double ux = this.x/this.mag();
		double uy = this.y/this.mag();
		double uz = this.z/this.mag();
		ThreeVector u = new ThreeVector(ux, uy, uz);
		return u;
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
}








}
