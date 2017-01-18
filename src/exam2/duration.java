package exam2;

public class duration implements Classification{
	
	public duration(){}

	@Override
	public String classify(double d) {
		if(d<=1){
			return "The sound is short";
		}
		return "The sound is long";
	}

}
