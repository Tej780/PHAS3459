package module6;

import java.util.Collection;
//all classes that implement GoodnessOfFitCalculator must either be abstract or define all methods in the interface
//seems a bit unnecessary for this simple problem, but would be useful if we added more implementations of this interface
public interface GoodnessOfFitCalculator {
	public double goodnessOfFit(Collection<DataPoint> data,Theory theory);
}
