package module6;

public class PowerLawTheory implements Theory{
	double n;

	public PowerLawTheory(double power){//set exponent of theoretical function to be fitted
		n=power;
	}

	/**
	 * calculates y = x^n
	 * @param x
	 * @return yTheory, the theoretical y value for the given x value
	 */
	public double y(double x){
		double yTheory = Math.pow(x,n);
		return yTheory;
	}

	@Override
	public String toString() {
		return "PowerLawTheory y = x^" + n ;
	}



}
