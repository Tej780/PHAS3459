public class Complex{
	double x,y;
	public Complex(){}
	public Complex(double a, double b){
		x=a;
		y=b;
}

	public double real(){
		return this.x;
}

	public double img(){
		return this.y;
}

	public double mod(){
		modulus = Math.sqrt(this.x*this.x + this.y*this.y);
}

	public double angle(){
		arg = Math.atan(this.y/this.x);
}

	public Complex conjugate(){
		double u = this.x;
		double v = -1*(this.y);
		Complex w = new Complex(u,v);
		return w;
}

	
}
