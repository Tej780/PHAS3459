package exam2;

public class LowMediumHigh implements Classification{

	LowMediumHigh(){}

	@Override
	public String classify(double d) {
		double[] f= {100,400,1000};
		if(d==f[0]){
			return "low";
		}else if(d==f[1]){
			return "medium";
		}
		return "high";
	}

}
