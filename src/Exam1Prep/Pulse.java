package Exam1Prep;

import java.util.ArrayList;

public class Pulse {
	
	String ID;
	ArrayList<Double> sig;

	//constructor
	public Pulse(String code, ArrayList<Double> signals){
		this.ID = code;
		sig = signals;
	}

	public String toString(){
		return "Detector " +ID + " has signals " + sig + "\n";
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
