package exam1;

public class Player {
	String name,team,pos;
	int games,ab,runs,hits,doubles,triples,homeRuns,rbi;
	double battingAvg,obp;
	
	public Player(String[] playerData){
		try{
		parse(playerData);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	private void parse(String[] playerData) throws Exception {
		if(playerData.length!=13){throw new Exception("The player data has the wrong number of fields");}
		name=playerData[0];
		team=playerData[1];
		pos=playerData[2];
		games=Integer.parseInt(playerData[3]);
		ab=Integer.parseInt(playerData[4]);
		runs=Integer.parseInt(playerData[5]);
		hits=Integer.parseInt(playerData[6]);
		doubles=Integer.parseInt(playerData[7]);
		triples=Integer.parseInt(playerData[8]);
		homeRuns=Integer.parseInt(playerData[9]);
		rbi=Integer.parseInt(playerData[10]);
		battingAvg=Double.parseDouble(playerData[11]);
		obp=Double.parseDouble(playerData[12]);

	}

	@Override
	public String toString() {
		return "[name=" + name + ", pos=" + pos + ", games=" + games + ", ab=" + ab + ", runs=" + runs
				+ ", hits=" + hits + ", doubles=" + doubles + ", triples=" + triples + ", homeRuns=" + homeRuns
				+ ", rbi=" + rbi + ", battingAvg=" + battingAvg + ", obp=" + obp + "]";
	}
}
