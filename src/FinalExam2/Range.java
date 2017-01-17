package FinalExam2;

import java.util.ArrayList;
import java.util.HashMap;

public class Range implements Statistic{
	
	public Range(){}

	@Override
	public void average(ArrayList<Tides> t, HashMap<String, String> s) {
		for(String id:s.keySet()){
			String name = s.get(id);
			double MaxSeaLevel=Double.NEGATIVE_INFINITY;
			double MinSeaLevel=Double.POSITIVE_INFINITY;
			for(Tides tide:t){
				if(tide.ID.equals(id)){
					if(tide.seaLevel>MaxSeaLevel){
						MaxSeaLevel=tide.seaLevel;
					}else if(tide.seaLevel<MinSeaLevel){
						MinSeaLevel=tide.seaLevel;
					}
				}
			}
			double Range = MaxSeaLevel-MinSeaLevel;
			System.out.println("For site "+id+", "+name+" the range in sea level is "+Range);
		}
		
	}

}
