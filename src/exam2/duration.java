package exam2;

public class duration implements Classification{

	public duration(){}

	//classifies sound sample based on the duration of the sample in seconds
	@Override
	public String classify(double d) {//here d represents the duration
		if(d<=1){//the limit is 1 second
			return "The sound is short";
		}
		return "The sound is long";
	}

}
