package exam2;

import java.util.ArrayList;

public class Audio {
	
		String instrument,filename;
		int sampleFreq,sampleNo,aMax;
		ArrayList<Integer> amplitude = new ArrayList<Integer>();
		
		public Audio(String name,String fname, int freq,int num, int max, ArrayList<Integer> amp){
			instrument = name;
			filename=fname;
			sampleFreq = freq;
			sampleNo = num;
			aMax = max;
			amplitude = amp;
		}

		@Override
		public String toString() {
			return "Filename:"+filename+" [instrument=" + instrument + ", sampleFreq=" + sampleFreq + ", sampleNo=" + sampleNo
					+ ", aMax=" + aMax + "]";
		}
}
