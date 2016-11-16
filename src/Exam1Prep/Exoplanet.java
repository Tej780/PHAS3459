package Exam1Prep;


public class Exoplanet {
	int length;
	String name;
	int date;
	String method;
	double mass;
	double seperation;
	double dist;

	public Exoplanet(String[] data){
		length=data.length;
		name=data[0];
		date=Integer.parseInt(data[1]);
		method=data[2];
		mass=Double.parseDouble(data[3]);
		seperation=Double.parseDouble(data[4]);
		if(data.length==6){
			dist=Double.parseDouble(data[5]);
		}
	}
	/*@Override
	public String toString(){
		String s = ("Name:"+name+" Date:"+date+" Method:"+method+" Mass:"+mass+" Seperation from parent star:"+seperation+" Distance from Earth:"+dist);
		return s;
	}*/

	@Override
	public String toString() {
		String s="";
		if(length<6){
			s="Exoplanet [name=" + name + ", date=" + date + ", method=" + method + ", mass=" + mass + ", seperation="
					+ seperation + ", dist=" + "N/A" + "]"+"\n";
		}else{
			s="Exoplanet [name=" + name + ", date=" + date + ", method=" + method + ", mass=" + mass + ", seperation="
					+ seperation + ", dist=" + dist + "]"+"\n";
		}
		return s;
		
	}
	


}
