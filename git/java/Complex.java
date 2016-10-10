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

	
	public static void main(String[] args){
		Complex z = new Complex(3,1);
		System.out.println(z.toString());
		System.out.println(z.conjugate());
		System.out.println(z.angle());
		System.out.println(z.modulus());
		System.out.println(z.real());
		System.out.println(z.img());

}
}
