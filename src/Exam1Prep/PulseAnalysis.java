package Exam1Prep;

import java.util.ArrayList;
import java.util.HashMap;

public class PulseAnalysis {	

	static ArrayList<Pulse> pulsesArray = new ArrayList<Pulse> (Signals.getSignals("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/signals.txt"));
	static HashMap<String, Double> distHash = new HashMap<String,Double> (Distance.getDist("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/detectors.txt"));

	public static void main(String[] args) {
		for(String s:distHash.keySet()){
			int noSignals=0;
			double meanAmp=0;
			double meanArrival=0;
			for(Pulse p:pulsesArray){

				if (p.ID.equals(s)){
					noSignals++;
					meanAmp+=p.amplitude;
					meanArrival+=p.arrival;
				}
			}
			meanAmp=meanAmp/noSignals;
			meanArrival=meanArrival/noSignals;
			double distance = distHash.get(s);
			double speed = distance/meanArrival;
			System.out.println("For Detector "+s+" the mean amplitude is "+meanAmp+" and the mean arrival time is "+meanArrival
					+".\nThe average speed of particles is "+speed);
		}

	}

}
