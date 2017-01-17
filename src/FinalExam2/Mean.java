package FinalExam2;

import java.util.ArrayList;
import java.util.HashMap;

public class Mean implements Statistic{
	
	public Mean(){}

	@Override
	public void average(ArrayList<Tides> t, HashMap<String, String> s) {
		for(String id:s.keySet()){
			String name = s.get(id);
			double totalSeaLevel=0;
			double counter = 0;
			for(Tides tide:t){
				if(tide.ID.equals(id)){
					counter++;
					totalSeaLevel+=tide.seaLevel;
				}
			}
			double meanSeaLevel = totalSeaLevel/counter;
			System.out.println("For site "+id+", "+name+" the mean sea level is "+meanSeaLevel);
		}
		
	}

}
