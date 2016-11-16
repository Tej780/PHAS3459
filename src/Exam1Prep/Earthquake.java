package Exam1Prep;

import java.util.ArrayList;
import java.util.Scanner;

public class Earthquake {

	double depth,depthError,magnitude,latitude,longitude,majErr,minErr,seconds;
	int ID,azimuth,hours,minutes,day,month,year;
	
	public Earthquake(int dd, int mm,int yy,int hh,int min,int az,
			double dp, double dpe,double m,int id,double lon,double lat,
			double eh1,double eh2,double ss){
		day=dd;
		month=mm;
		year=yy;
		hours=hh;
		minutes=min;
		seconds=ss;
		latitude=lat;
		longitude=lon;
		azimuth=az;
		majErr=eh1;
		minErr=eh2;
		depth=dp;
		depthError=dpe;
		magnitude=m;
		ID=id;
	}
	
	/*public Earthquake parseData(String line){
		Scanner s=new Scanner(line);
		while(s.hasNext()){
			year= Integer.parseInt(s.next());
			month= Integer.parseInt(s.next());
			day= Integer.parseInt(s.next());
			hours= Integer.parseInt(s.next());
			minutes= Integer.parseInt(s.next());
			seconds= Double.parseDouble(s.next());
			latitude= Double.parseDouble(s.next());
			longitude= Double.parseDouble(s.next());
			depth= Double.parseDouble(s.next());
			majErr= Double.parseDouble(s.next());
			minErr= Double.parseDouble(s.next());
			azimuth= Integer.parseInt(s.next());
			depthError= Double.parseDouble(s.next());
			magnitude= Double.parseDouble(s.next());
			ID= Integer.parseInt(s.next());
		}
		s.close();
		
		return earthquake;
	}*/
}
