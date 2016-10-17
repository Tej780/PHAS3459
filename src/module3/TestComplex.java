package module3;

public class TestComplex{

	public static void main(String[] args){
		//Produce complex number objects 
		Complex c1 = new Complex(2,-1);
		Complex c2 = new Complex(-1,2);
		try{	
			System.out.println("C1/C2 = "+Complex.divide(c1,c2));
			System.out.println("C1/0 = "+Complex.divide(c1,Complex.ZERO));

		}catch(ArithmeticException e){
			System.out.println("Cannot normalise 0!");

		}catch(Exception e){
			System.out.println("Cannot divide by 0!");

		}finally{
			System.out.println("C1 x C2 = "+Complex.multiply(c1,c2));
			System.out.println("C1 x i = "+Complex.multiply(c1,Complex.I));
			System.out.println("C1 x C1* = "+Complex.multiply(c1,c1.conjugate()));
			System.out.println("C2 x C2* = "+Complex.multiply(c2,c2.conjugate()));	
		}
	}

}
