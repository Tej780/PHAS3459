package FinalExam2;

public class Tides {
	String ID;
	int year;
	byte month,day,hour,minute;
	double seaLevel,predictedLevel;
	
	public Tides(String id,int Year,byte Month, byte Day,byte Hour,byte Minute,double SeaLevel,double PredictedLevel){
		ID=id;
		year=Year;
		month=Month;
		day=Day;
		hour=Hour;
		minute=Minute;
		seaLevel=SeaLevel;
		predictedLevel=PredictedLevel;
	}

	

	
	
}
