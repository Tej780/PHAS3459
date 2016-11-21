package module6;

import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

	/**
	 * Finds the Theory with the best fit to the Data
	 * @param data, list of DataPoints
	 * @param theories, list of theories to be tested and compared
	 * @param gofCalculator, object defining how goodness of fit is calculated
	 * @return bestTheory, the theory with the best fit to the data
	 */
	private static Theory bestTheory(Collection<DataPoint> data,Collection<Theory> theories, GoodnessOfFitCalculator gofCalculator) {
		boolean first = true;
		double bestGoodnessOfFit = 0.0;
		Theory bestTheory = null;
		for (Theory theory : theories) {
			double gof = gofCalculator.goodnessOfFit(data, theory);
			if (first) {//find the first theory in order to compare to all later theories
				bestTheory = theory;
				bestGoodnessOfFit = gof;
				first = false;
			} else if (gof < bestGoodnessOfFit) {
				bestTheory = theory;
				bestGoodnessOfFit = gof;
			}
		}
		System.out.println("The best Chi Squared Value is: "+bestGoodnessOfFit);
		return bestTheory;
	}

	public static void main(String[] args) {
		Collection<DataPoint> data = new ArrayList<DataPoint>();//holds all DataPoints
		Collection<Theory> theories = new ArrayList<Theory>();//holds theories
		data=TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
		//make theories and add to collection
		Theory one = new PowerLawTheory(2);
		Theory two = new PowerLawTheory(2.05);
		Theory three = new QuadraticTheory(1,10,0);
		theories.add(one);
		theories.add(two);
		theories.add(three);
		//Must make a ChiSquared object as goodnessOfFit cannot be static without putting a body in GoodnessOfFitCalculator
		//which defeats the purpose of the interface
		ChiSquared c=new ChiSquared();
		Theory best =bestTheory(data,theories,c);
		System.out.println("The best theory is: "+best);


		/*
		//just for fun. Seems more useful than manually testing 3 theories
		for(double a=0;a<10;a+=0.05){
			for(double b=0;b<10;b+=0.05){
				for(double c=0;c<10;c+=0.05){
					//find all (8000000) combinations of coefficients a,b,and c between 0 and 10 i increments of 0.05
					QuadraticTheory q = new QuadraticTheory(a,b,c);
					theories.add(q);
				}
			}
		}
		//find all (10001) theories with powers between 0 and 10 in increments of 0.001
		for(double n=0;n<10;n+=0.001){
			PowerLawTheory p = new PowerLawTheory(n);
			theories.add(p);
		}

		//find and print the best theoretical model
		ChiSquared c=new ChiSquared();
		Theory best =bestTheory(data,theories,c);
		System.out.println("The best theory is: "+best);

		//unamusingly, the best value for chi squared is the one given in the assignment, so trying these 8010001 theories is pretty much useless
		 */

	}
}
