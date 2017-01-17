package Exam1Prep;

import java.util.ArrayList;

public class Threshold implements Time{
	
	static double threshold;
	
	public Threshold(double t){
		threshold=t;
	}
	
	public static double arrival(ArrayList<Pulse> pulses){
		double arrivalTime =-1;
		for (Pulse p:pulses){
			for(double d:p.sig){
				arrivalTime++;
				if(d>threshold){
					break;
				}
			}
		}
		return arrivalTime;
	}
}
