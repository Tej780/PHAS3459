package module2;

public class Complex{
	double x,y;
	public Complex(){}
	public Complex(double a, double b){
		x=a;
		y=b;
		    			  }
	/**
	 * Returns the real part of the complex number
	 * @return x, real part
	 */
	public double real(){
		return this.x;
			    }
	/**
	 * Returns the imaginary part of the complex number
	 * @return y, imaginary part
	 */
	public double img(){
		return this.y;
			   }
	/**
	 * Calculates the modulus (length) of the complex number
	 * @return modulus
	 */
	public double modulus(){
		double mod = Math.sqrt(this.x*this.x + this.y*this.y);
		return mod;
			       }
	/**Calculates the angle between the complex number and the positive real axis within the range [-90,90]
	*@return argument
	*
	*/
	public double angle(){
		double arg = Math.toDegrees(Math.atan(this.y/this.x));
		return arg;
			     }
	/**Calculates the complex conjugate of the complex number
	*@return conjugate
	*/
	public Complex conjugate(){
		double u = this.x;
		double v = -1*(this.y);
		Complex w = new Complex(u,v);
		return w;
				  }
	/**Normalises the complex number, thus finding a number with the same argument but modulus 1.
	*
	*/
	public Complex normalised(){                    
		double xhat = this.x/this.modulus();
                double yhat = this.y/this.modulus();
                Complex rhat = new Complex(xhat, yhat);
                return rhat;
				   }
	/**checks if two complex numbers are equal
	*@return true or false
	*/
	public boolean equals(Complex c){
		if(this == c){
			return true;
			     }		
		else{
			return false;
		    }
					}
	/**Converts toe complex number to a string to be printed
	*	
	*/
	public String toString(){
		String z;
		if (this.y<0){
			z = (this.x + " - " + -1*this.y + "i");
			     }		
		else {
			z = (this.x + " + " + this.y + "i");
		     }
		return z;
				}
	/**Allows you to create a Complex object using the angle and modulus
	*@return Complex 
	*/
	public static Complex setFromModulusAngle(double mag, double ang){
		double x = mag*Math.cos(ang);
		double y = mag*Math.sin(ang);
		Complex z = new Complex(x,y);
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
	/**Allows you to add two complex numbers together
	*/
	public static Complex add(Complex z, Complex w){
		double a = z.x + w.x;
		double b = z.y + w.y;
		Complex c = new Complex(a,b);
		return c;
						       }
	/**Allows you to add subtract a complex number from another
	*/	
	public static Complex subtract(Complex z, Complex w){
                double a = z.x - w.x;
                double b = z.y - w.y;
                Complex c = new Complex(a,b);
                return c;
							    }
	/**Allows you to add multiply complex numbers together
	*/
	public static Complex multiply(Complex z, Complex w){
                double a = z.x*w.x - z.y*w.y;
                double b = z.y*w.x + w.y*z.x;
                Complex c = new Complex(a,b);
                return c;
							    }
	/**Allows you to divide a complex number by another
	*/
	  public static Complex divide(Complex z, Complex w){
                Complex a = Complex.multiply(z,w.conjugate());
                double b = w.x*w.x + w.y*w.y;
                Complex c = new Complex(a.x/b, a.y/b);
                return c;
							    }

      

}
