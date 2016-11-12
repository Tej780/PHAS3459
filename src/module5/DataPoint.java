package module5;

public class DataPoint{
	double x,y,ey;

	public DataPoint(double xPoint, double yPoint, double error){
		x=xPoint;
		y=yPoint;
		ey=error;
}
	
	public String toString(){
		String dataString=(x+", "+y+", "+ey);
		return dataString;
	}
	
	public DataPoint(double[] datapoint){
		x=datapoint[0];
		y=datapoint[1];
		ey=datapoint[2];
}

	public double getX(){
		return x;
}

	public double getY(){
		return y;
}

	public double getErr(){
		return ey;
	}
	
	public static DataPoint parse(String measurement){
		String[] measure = measurement.split("  ");
		double[] datapoint = new double[measure.length];
		for (int i = 0; i<datapoint.length;i++){
			datapoint[i]=Double.parseDouble(measure[i]);
		}
		DataPoint dp = new DataPoint(datapoint);
		return dp;
	}

}
