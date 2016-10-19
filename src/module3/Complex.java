package module3;

public class Complex{

	private double real,imag;
	public Complex(){}
	public Complex(double a, double b){//represents the complex number a + bi
		real=a;
		imag=b;
	}

	//Complex numbers representing 1,0 and i
		static final Complex ONE = new Complex(1,0);
		static final Complex ZERO = new Complex();
		static final Complex I = new Complex(0,1);
	
	/**
	 * Returns the real part of the complex number
	 * @return x, real component
	 */
	public double real(){
		return this.real;
	}
	/**
	 * Returns the imaginary part of the complex number
	 * @return y, imaginary component
	 */
	public double img(){
		return this.imag;
	}


	/**
	 * Calculates the modulus (length) of the complex number
	 * @return modulus
	 */
	public double modulus(){
		double mod = Math.sqrt(this.real*this.real + this.imag*this.imag);
		return mod;
	}
	/**
	 *Calculates the angle anticlockwise from the positive real axis
	 *@return argument
	 */
	public double angle(){
		double arg = 0;
		//determines in which quadrant the complex number resides
		arg = Math.toDegrees(Math.atan2(this.imag,this.real));

		return arg;
	}


	/**
	 *Calculates the complex conjugate of the complex number
	 *@return conjugate
	 */
	public Complex conjugate(){
		double u = this.real;
		double v = -(this.imag);
		Complex w = new Complex(u,v);
		return w;
	}


	/**
	 *Normalises the complex number, thus finding a number with the same argument but modulus 1.
	 *@return Normalised Complex number
	 */
	public Complex normalised() throws ArithmeticException{

		double mod = this.modulus();
		double xhat = this.real/mod;
		double yhat = this.imag/mod;
		//prevents the program from normalising 0
		if(this.modulus()==0){
			throw new ArithmeticException();
		}
		Complex rhat = new Complex(xhat, yhat);

		return rhat;
	}


	/**
	 *checks if two complex numbers are equal
	 *@return true or false
	 */
	public boolean equals(Complex c){
		if(this.real == c.real && this.imag == c.imag){//checks that the components of two Complex objects are the same
			return true;
		}		
		else{
			return false;
		}
	}


	/**
	 *Converts the complex number to a string so that it can be printed	
	 */
	public String toString(){
		String z;
		if (this.imag<0){
			z = (this.real + " - " + -1*this.imag + "i");
		}		
		else {
			z = (this.real + " + " + this.imag + "i");
		}
		return z;
	}


	/**
	 *Creates a Complex object using the angle and modulus
	 *@return Complex 
	 */
	public static Complex setFromModulusAngle(double mag, double ang){
		double x = mag*Math.cos(ang);
		double y = mag*Math.sin(ang);
		Complex z = new Complex(x,y);
		return z;
	}

	/**
	 *Adds two complex numbers together
	 */
	public static Complex add(Complex z, Complex w){
		double a = z.real + w.real;
		double b = z.imag + w.imag;
		Complex c = new Complex(a,b);
		return c;
	}

	/**
	 *Subtracts a complex number from another
	 */	
	public static Complex subtract(Complex z, Complex w){
		double a = z.real - w.real;
		double b = z.imag - w.imag;
		Complex c = new Complex(a,b);
		return c;
	}

	/**
	 *Multiplies two complex numbers together
	 */
	public static Complex multiply(Complex z, Complex w){
		double a = z.real*w.real - z.imag*w.imag;
		double b = z.imag*w.real + w.imag*z.real;
		Complex c = new Complex(a,b);
		return c;
	}

	/**
	 *Divides one complex number by another
	 */
	public static Complex divide(Complex z, Complex w) throws Exception{

		Complex a = Complex.multiply(z,w.conjugate());
		double b = w.modulus()*w.modulus();
		//prevents the program from dividing by 0
		if(b==0){
			throw new Exception();
		}
		Complex c = new Complex(a.real/b, a.imag/b);

		return c;
	}


	/*
	public static void main(String[] args){
		Complex z = new Complex(0,0);
		Complex w = new Complex(6,10);
		//System.out.println(Complex.divide(z,w));
		System.out.println(w.normalised());
		System.out.println(z.toString());
		System.out.println(z.conjugate());
		System.out.println(z.angle());
		System.out.println(z.modulus());
		System.out.println(z.real());
		System.out.println(z.img());
		System.out.println(ZERO.normalised());
		System.out.println(z.equals(ZERO));
					      }
	*/ 


}
