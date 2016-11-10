package module5;

public class Theory{
	int n;
	double yTheory;
	double xTheory;
	public Theory(int power){
		n=power;
		}

	public double y(double x){
		xTheory=x;
		yTheory = Math.pow(x,n);
		return yTheory;
	}
	
}
