package exam2;

public class volume implements Classification {

	public volume(){}

	//classifies sound based on the volume of the sample
	@Override
	public String classify(double d) {//here d represents the volume in dBFS
		if(d>-20){//the limit has been set to -20 dBFS
			return "The sound is loud";
		}
		return "The sound is quiet";
	}

}
