package exam2;

public class ExamPart2 extends ExamPart1{//rather than copy and paste all the methods from part 1, I simply make this class a subclass

	public static void main(String[] args) {
		indexdata("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");
		audiodata();

		//create objects to allow us to use each of the classify methods
		duration d=new duration();
		volume v = new volume();
		//As far as I am aware, the version of Java that we are using does not allow for static interfaces (I don't see why we shouldn't)
		//and so I am forced to create empty objects to allow me to access the methods implemented by the interface

		for(Audio a:audio){//for every audio sample, classify the sample using both methods
			System.out.println("\nFile name: "+a.filename);
			System.out.println("Instrument: "+a.instrument);

			double duration = (a.sampleNo)/a.sampleFreq;
			System.out.println("Duration: "+duration+" s");
			System.out.println(d.classify(duration));


			double square=0;
			for(double i :a.amplitude){
				square+=(i*i);
			}
			double meanSquare = square/a.sampleNo;
			double RMS = Math.sqrt(meanSquare);

			double A = 20*(Math.log10(RMS/a.aMax));
			System.out.println("Amplitude of signal in dBFS: "+A);
			System.out.println(v.classify(A));


		}	
	}

}
