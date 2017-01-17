package Exam1Prep;

import java.util.ArrayList;

public class Pulse {

	String ID;
	ArrayList<Double> sig;
	double amplitude;
	double arrival;

	//constructor
	public Pulse(String code, ArrayList<Double> signals,double amp,double time){
		this.ID = code;
		sig = signals;
		amplitude=amp;
		arrival=time;
	}

	public String toString(){
		return "Detector " +ID + " has signals " + sig + ".\nThe max amplitude is "+amplitude+" and the arrival time is "+arrival+"s";
	}

	public String getID() {
		return ID;
	}

	public  void setID(String iD) {
		ID = iD;
	}

	public  ArrayList<Double> getSig() {
		return sig;
	}

	public void setSig(ArrayList<Double> sig) {
		this.sig = sig;
	}
}
