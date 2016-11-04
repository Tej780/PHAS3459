//package module5;

public class Theory{
	int n;
	double yTheory;
	public Theory(int power){
		n=power;
		}

	public double y(double x){
		yTheory = Math.pow(x,n);
		return yTheory;
	}
	
}
