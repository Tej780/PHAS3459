package module6;

public class LabelledDataPoint extends DataPoint{

	String label;

	public LabelledDataPoint(double xPoint, double yPoint, double error, String lb) {
		super(xPoint, yPoint, error);
		label=lb;
	}

	public LabelledDataPoint(double[] datapoint,String lb) {
		super(datapoint);
		label=lb;
	}

	public String toString(){
		String lbString = label+": x = "+ x +", y = "+ y +" +/- "+ey;
		return lbString;
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
		for (int i = 0; i<3;i++){
			try{
				datapoint[i]=Double.parseDouble(measure[i]);
			}catch(Exception e){
				System.out.println("Error! Data includes non numeric character");
			}
		}
		DataPoint dp;
		if(measure.length==4){
			String lb=measure[3];
			dp = new LabelledDataPoint(datapoint,lb);
		}else{
			dp = new DataPoint(datapoint);
		}
		return dp;
	}
}
