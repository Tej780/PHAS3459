package module5;

public class Theory{
	int n;

	public Theory(int power){
		n=power;
		}

	public double y(double x){
		double yTheory = Math.pow(x,n);
		return yTheory;
	}
	
}
