package Exam1Prep;

public class Detectors {

	String ID;
	double d;

	//constructor
	public Detectors(String code, double distance){
		this.ID = code;
		this.d = distance;
	}

	public String toString(){
		return "Detector " +ID + " is " + d + "m away" +"\n";	
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

}
