package module6;

public class PowerLawTheory implements Theory{
	int n;

	public PowerLawTheory(int power){//set exponent of theoretical function to be fitted
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
