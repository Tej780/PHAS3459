package module6;

public class DataPoint{
	double x,y,ey;

	//construct DataPoint using individual values
	public DataPoint(double xPoint, double yPoint, double error){
		x=xPoint;
		y=yPoint;
		ey=Math.abs(error);//assumes a negative error is same as positive error (i.e. +/- errorvalue) 
	}

	//construct from an array representing the values
	public DataPoint(double[] datapoint){
		x=datapoint[0];
		y=datapoint[1];
		ey=Math.abs(datapoint[2]);//assumes a negative error is same as positive error (i.e. +/- errorvalue) 
	}

	public String toString(){
		String dataString=("x= "+x+", y= "+y+" +/- "+ey);
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
		//technically allows for strings containing more data columns, but the DataPoint constructor will only take the first 3 values it comes across
		for (int i = 0; i<datapoint.length;i++){
			try{
			datapoint[i]=Double.parseDouble(measure[i]);
			}catch(Exception e){
				System.out.println("Error! Data includes non numeric character");
			}
		}
		DataPoint dp = new DataPoint(datapoint);
		return dp;
	}
}
