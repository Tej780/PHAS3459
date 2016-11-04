//package module5;

public class DataPoint{
	double x,y,ey;

	public DataPoint(double xPoint, double yPoint, double error){
		x=xPoint;
		y=yPoint;
		ey=error;
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

}
