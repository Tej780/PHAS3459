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
	 * @return x, real component
	 */
	public double real(){
		return this.x;
			    }
	/**
	 * Returns the imaginary part of the complex number
	 * @return y, imaginary component
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
	/**
	*Calculates the angle anticlockwise from the positive real axis
	*@return argument
	*/
	public double angle(){
		double arg = 0;
		//determines in which quadrant the complex number resides
		if(x==0 && y==0){//for the complex number 0, the argument is 0
			arg = 0;
		}else if(this.x>=0 && this.y>=0){//1st quadrant
			arg = Math.toDegrees(Math.atan(this.y/this.x));
		}else if(this.x<=0 && this.y>=0){//2nd quadrant
			arg = 180 + Math.toDegrees(Math.atan(this.y/this.x));
		}else if(this.x<=0 && this.y<=0){//3rd quadrant
			arg = 360 + Math.toDegrees(Math.atan(this.y/this.x));
		}else if(this.x>=0 && this.y<=0){//4th quadrant
			arg = 180 + Math.toDegrees(Math.atan(this.y/this.x));
		}
		return arg;
			     }


	/**
	*Calculates the complex conjugate of the complex number
	*@return conjugate
	*/
	public Complex conjugate(){
		double u = this.x;
		double v = -1*(this.y);
		Complex w = new Complex(u,v);
		return w;
				  }


	/**
	*Normalises the complex number, thus finding a number with the same argument but modulus 1.
	*@return Normalised Complex number
	*/
	public Complex normalised() throws ArithmeticException{
		Complex rhat = new Complex();
		try{
			double xhat = this.x/this.modulus();
                	double yhat = this.y/this.modulus();
			//prevents the program from normalising 0
			if(this.modulus()==0){
				throw new ArithmeticException();
						}
                	rhat = new Complex(xhat, yhat);
                
		}catch(ArithmeticException e){
			System.out.println("Cannot normalise 0!");
		}	
		return rhat;
				}


	/**
	*checks if two complex numbers are equal
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


	/**
	*Converts the complex number to a string so that it can be printed	
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

	//Complex numbers representing 1,0 and i
	static Complex ONE = new Complex(1,0);
	static Complex ZERO = new Complex();
	static Complex I = new Complex(0,1);

	/**
	*Adds two complex numbers together
	*/
	public static Complex add(Complex z, Complex w){
		double a = z.x + w.x;
		double b = z.y + w.y;
		Complex c = new Complex(a,b);
		return c;
						       }

	/**
	*Subtracts a complex number from another
	*/	
	public static Complex subtract(Complex z, Complex w){
                double a = z.x - w.x;
                double b = z.y - w.y;
                Complex c = new Complex(a,b);
                return c;
							    }

	/**
	*Multiplies two complex numbers together
	*/
	public static Complex multiply(Complex z, Complex w){
                double a = z.x*w.x - z.y*w.y;
                double b = z.y*w.x + w.y*z.x;
                Complex c = new Complex(a,b);
                return c;
							    }

	/**
	*Divides one complex number by another
	*/
	  public static Complex divide(Complex z, Complex w) throws ArithmeticException{
                Complex c = new Complex();
		try{
			Complex a = Complex.multiply(z,w.conjugate());
                	double b = w.modulus();
			//prevents the program from dividing by 0
			if(b==0){
				throw new ArithmeticException();
				}
                	c = new Complex(a.x/b, a.y/b);
		}catch(ArithmeticException e){
			System.out.println("Cannot divide by 0!");
			return null;
							}
                return c;
							    }


	/*
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
		System.out.println(ZERO.normalised());
		System.out.println(Complex.divide(z,ZERO));
					      }

	*/
                        
}
