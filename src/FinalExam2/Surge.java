package FinalExam2;

import java.util.ArrayList;
import java.util.HashMap;

public class Surge {
	public static void highestSurge(ArrayList<Tides> tides, HashMap<String,String> sites){
		double highSurge=Double.NEGATIVE_INFINITY;
		String id = "";
		String date = "";
		String time = "";
		String name="";
		for(Tides t:tides){
			double surge = t.predictedLevel - t.seaLevel;
			if(surge>highSurge){
				highSurge=surge;
				id=t.ID;
				name = sites.get(id);
				date= t.day+"/"+t.month+"/"+t.year;
				time= t.hour+":"+t.minute;
			}
		}
		System.out.println("The highest surge had size "+highSurge+" and occured at "+date+", "+time+" at "+name+", "+id);
	}
}
