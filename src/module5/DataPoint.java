package module5;

public class DataPoint{
	double x,y,ey;

	//construct DataPoint using individual values
	public DataPoint(double xPoint, double yPoint, double error){
		x=xPoint;
		y=yPoint;
		ey=error;
	}

	//construct from an array representing the values
	public DataPoint(double[] datapoint){
		x=datapoint[0];
		y=datapoint[1];
		ey=datapoint[2];
	}

	public String toString(){
		String dataString=(x+", "+y+", "+ey);
		return dataString;
	}

	//These don't really need comments or docstrings. This comment is self contradictary =D
	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}

	public double getErr(){
		return ey;
	}

	/**
	 * Turns a string of the 3 datapoints and convert it to a DataPoint object
	 * @param measurement
	 * @return dp, DataPoint 
	 */
	public static DataPoint parse(String measurement){
		String[] measure = measurement.split("  ");//separate values before converting to doubles
		double[] datapoint = new double[measure.length];
		for (int i = 0; i<datapoint.length;i++){
			datapoint[i]=Double.parseDouble(measure[i]);
		}
		DataPoint dp = new DataPoint(datapoint);
		return dp;
	}
}
