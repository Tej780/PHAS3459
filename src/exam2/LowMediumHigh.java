package exam2;

public class LowMediumHigh implements Classification{

	LowMediumHigh(){}

	//classifies the sound by the maximum spectral density of the sound
	@Override
	public String classify(double d) {
		//ideally I would make it so the limits for what counts as low, medium or high can be defined by the user, but this is sufficient for now
		double[] f= {100,400,1000};
		if(d==f[0]){
			return "low";
		}else if(d==f[1]){
			return "medium";
		}
		return "high";
	}

}
