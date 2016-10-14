//package module2;

public class TestComplex{

	public static void main(String[] args){
		//Produce complex number objects 
		Complex c1 = new Complex(2,-1);
		Complex c2 = new Complex(-1,2);
		System.out.println(Complex.multiply(c1,c2));
		System.out.println(Complex.divide(c1,c2));
		System.out.println(Complex.multiply(c1,Complex.I));
		System.out.println(Complex.divide(c1,Complex.ZERO));
		System.out.println(Complex.multiply(c1,c1.conjugate()));
		System.out.println(Complex.multiply(c2,c2.conjugate()));
		System.out.println(c1.angle());
					      }

			}
