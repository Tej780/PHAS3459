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

	public double modulus(){
		double mod = Math.sqrt(this.x*this.x + this.y*this.y);
		return mod;
}

	public double angle(){
		double arg = Math.atan(this.y/this.x);
		return arg;
}

	public Complex conjugate(){
		double u = this.x;
		double v = -1*(this.y);
		Complex w = new Complex(u,v);
		return w;
}

	public boolean equals(Complex c){
		if(this == c){
			return true;
}		else{
			return false;
}
}

	public String toString(){
		String z;
		if (this.y<0){
			z = (this.x + " - " + -1*this.y + "i");
}		else {
			z = (this.x + " + " + this.y + "i");
}
		return z;
}

	static Complex ONE = new Complex(1,0);
	static Complex ZERO = new Complex();
	static Complex I = new Complex(0,1);

	public static void main(String[] args){
		Complex z = new Complex(0.6,0.8);
		Complex w = new Complex(6,10);
		System.out.println(Complex.divide(z,w));
		System.out.println(w.normalised());
		System.out.println(z.toString());
		System.out.println(z.conjugate());
		System.out.println(z.angle());
		System.out.println(z.modulus());
		System.out.println(z.real());
		System.out.println(z.img());

}

	public static Complex setFromModulusAngle(double mag, double ang){
		double x = mag*Math.cos(ang);
		double y = mag*Math.sin(ang);
		Complex z = new Complex(x,y);
		return z;
}

	public static Complex add(Complex z, Complex w){
		double a = z.x + w.x;
		double b = z.y + w.y;
		Complex c = new Complex(a,b);
		return c;
}

	public static Complex subtract(Complex z, Complex w){
                double a = z.x - w.x;
                double b = z.y - w.y;
                Complex c = new Complex(a,b);
                return c;
}

	public static Complex multiply(Complex z, Complex w){
                double a = z.x*w.x - z.y*w.y;
                double b = z.y*w.x + w.y*z.x;
                Complex c = new Complex(a,b);
                return c;
}

	  public static Complex divide(Complex z, Complex w){
                Complex a = Complex.multiply(z,w.conjugate());
                double b = w.x*w.x + w.y*w.y;
                Complex c = new Complex(a.x/b, a.y/b);
                return c;
}

	public Complex normalised(){
		double xhat = this.x/this.modulus();
                double yhat = this.y/this.modulus();
                Complex rhat = new Complex(xhat, yhat);
                return rhat;
}

}
