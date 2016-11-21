package module6;

public class QuadraticTheory implements Theory{
	double a,b,c;

	public QuadraticTheory(double x1, double x2, double x3){//set coefficients of theoretical function to be fitted
		a=x1;
		b=x2;
		c=x3;
	}


	/**
	 * calculates y = ax^2 + bx + c
	 * @param x
	 * @return yTheory, the theoretical y value for the given x value
	 */
	public double y(double x){
		double yTheory = (Math.pow(x,2)*a)+(b*x)+c ;
		return yTheory;
	}


	@Override
	public String toString() {
		return "QuadraticTheory y = " + a + "x^2 + " + b + "x + " + c;
	} 

}
