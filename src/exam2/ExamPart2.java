package exam2;



public class ExamPart2 extends ExamPart1{

	public static void main(String[] args) {
		indexdata("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2016-17/index.txt");
		audiodata();

		duration d=new duration();
		volume v = new volume();

		for(Audio a:audio){
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
