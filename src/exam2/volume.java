package exam2;

public class volume implements Classification {

	public volume(){}

	@Override
	public String classify(double d) {
		if(d>-20){
			return "The sound is loud";
		}
		return "The sound is quiet";
	}

}
