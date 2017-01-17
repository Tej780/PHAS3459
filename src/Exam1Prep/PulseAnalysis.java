package Exam1Prep;

import java.util.ArrayList;
import java.util.HashMap;

import exam1.Player;

public class PulseAnalysis {	

	static //fill hashmaps with ID, signals
	ArrayList<Pulse> pulsesArray = new ArrayList<Pulse> (Signals.getSignals("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/signals.txt"));
	ArrayList<Detectors> distHash = new ArrayList<Detectors> (Distance.getDist("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/detectors.txt"));

	public static void main(String[] args) {

		//creating empty HashMap(K,V)
		HashMap<String, Double> hmapDist = new HashMap<String, Double>();
		HashMap<String, ArrayList> hmapPulse = new HashMap<String, ArrayList>();

		
		int i=0;
		double amp =0;
		//looping through array list to get number of pulses
		//for each object in array list, return the array list of the signals
		for (Pulse number : pulsesArray){		
			//System.out.println(number);
			amp = Signals.arrivalTime(number.getSig());
			//iterate count to get total number of players
			i++;	
			System.out.println("amplitude " +amp);

		}
		
		System.out.println("number of pulses is " +i);
		
	}

}
