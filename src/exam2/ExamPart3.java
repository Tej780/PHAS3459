package exam2;


public class ExamPart3 extends ExamPart2{

	public static void main(String[] args) {

		indexdata("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");
		audiodata();

		double[] f= {100,400,1000};
		for(Audio a:audio){
			System.out.println("Audio: "+a.instrument+", "+a.filename);
			double[] d = new double[f.length];
			for(int i=0;i<f.length;i++){
				d[i]=spectralDensity(a,f[i]);

			}

			double max = Double.NEGATIVE_INFINITY;
			double maxFreq=0;
			for (int i=0;i<d.length;i++) {
				System.out.println(d[i]);
				if (d[i] > max) {
					max=d[i];
					maxFreq=f[i];
				}
			}

			LowMediumHigh lmh = new LowMediumHigh();
			System.out.println(lmh.classify(maxFreq));

		}

	}

	private static double spectralDensity(Audio a,double f) {
		double t = (a.sampleNo/a.sampleFreq);
		double bigN = a.sampleNo;
		double z = 2 * Math.PI * f * t / bigN;
		double sumCos = 0;
		double sumSin = 0;
		for (int n = 0; n < bigN; ++n) {
			sumCos += a.amplitude.get(n)* Math.cos(z*n);
			sumSin += a.amplitude.get(n)* Math.sin(z*n);
		}
		double norm = t / (bigN*bigN);
		return norm * (sumCos*sumCos + sumSin*sumSin);
	}

}
