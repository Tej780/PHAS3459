package module6;

import java.util.Collection;
import java.util.Iterator;

public class ChiSquared {
	/**
	 * Calculates Chi Square for a given theoretical function
	 * @param ty, Theory object representing y = x^n
	 * @param dps, ArrayList of Datapoints
	 * @return
	 */
	public double goodnessOfFit(Collection<DataPoint> dps,Theory ty){
		double chiSquared = 0;//initialize chiSquared
		Iterator<DataPoint> iter = dps.iterator();
		while(iter.hasNext()){//loop through all DataPoints in the list
			DataPoint dp = iter.next();//get the nth DataPoint
			double x = dp.getX();
			double yTheory = ty.y(x);
			//calculate sum of (y - yTheory)^2/error^2
			chiSquared += Math.pow((dp.getY()-yTheory), 2)/Math.pow(dp.getErr(), 2);
		}
		return chiSquared;
	}
}
