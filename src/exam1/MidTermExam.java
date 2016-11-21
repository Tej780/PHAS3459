package exam1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MidTermExam {
	//I wanted to find each unique team so created a set of strings
	static Set<String> teams = new HashSet<String>();

	/**
	 * Gets data from a url represented by a url string
	 * @param url
	 */
	public static ArrayList<Player> dataFromURL(String url){
		ArrayList<Player> AllPlayers=new ArrayList<Player>();
		try{
			//get data from URL
			URL u = new URL(url);
			InputStream is = u.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			String line="";
			//skip first two lines
			br.readLine();
			br.readLine();

			//Turn each line into a Player object and add to the Player list
			while((line=br.readLine()) !=null){
				//split string into tokens with tabs as the delimiter
				Scanner s = new Scanner(line);
				s.useDelimiter("\t");
				//String array to be used to build the PLayer object
				String[] player=new String[13];
				//Since I wanted to hold the team names separately, I manually added the player name and team name first
				player[0]=s.next();
				String team=s.next();
				player[1]=team;
				//I then added each team name to the set for iteration later in the data analysis
				teams.add(team);
				//and looped through the rest of the values in each line
				int i=2;
				while(s.hasNext()){
					player[i]=s.next();
					i++;
				}
				Player p = new Player(player);
				AllPlayers.add(p);
				s.close();	
			}
		}catch(FileNotFoundException e){
			System.out.println(e);
		}catch(MalformedURLException e){
			System.out.println(e);
		}catch(IOException e){
			System.out.println(e);
		}
		return AllPlayers;
	}



	/**
	 * Checks if each player has more home runs than previous players in the list. Thus, finds the player with the most home runs
	 * @param allPlayers
	 */
	private static void MostHomeRuns(ArrayList<Player> allPlayers) {
		//initialise variables
		int maxHomeRuns=Integer.MIN_VALUE;
		Player best=null;

		for(Player p:allPlayers){
			if(p.homeRuns>maxHomeRuns){
				maxHomeRuns=p.homeRuns;
				best=p;
			}
		}
		System.out.println("The player with the most home runs is: "+best.name+", with "+maxHomeRuns+" home runs");
	}


	/**
	 * Takes the list of Players and analyses the data
	 * @param allPlayers
	 */
	private static void EachTeam(ArrayList<Player> allPlayers) {

		Iterator<String> iter = teams.iterator();
		while(iter.hasNext()){//analyse the data for a given team
			String team=iter.next();
			//variables for calculations
			int teamAtBats=0;
			double slugger=Double.NEGATIVE_INFINITY;
			double bestOPS=Double.NEGATIVE_INFINITY;
			Player bestSlugger=null;
			Player bestOPSPlayer=null;
			for(Player p:allPlayers){
				if(p.team.equals(team)){//if the player is in the team...
					if(p.ab>=10){//...and has at least 10 AtBats, analyse
						teamAtBats++;
						//finds highest slugging percentage
						double sluggingPercentage = ((double)p.hits + (double)(2*p.doubles)+(double)(3*p.triples)+(double)(4*p.homeRuns))/(double)p.ab;
						if(sluggingPercentage>slugger){

							slugger=sluggingPercentage;
							bestSlugger=p;
						}
						//finds highest OPS
						double ops=p.obp+sluggingPercentage;
						if(ops>bestOPS){
							bestOPS=ops;
							bestOPSPlayer=p;
						}
					}


				}
			}
			System.out.println("\n"+team+" has "+teamAtBats+" players with 10 or more AtBats");
			System.out.println("In the team "+team+" the player with the highest Slugging Percentage is: "
					+bestSlugger.name+ ", with a slugging percentage of "+slugger);
			System.out.println("The player with the highest On-Base plus Slugging figure is: "
					+bestOPSPlayer.name+", with an OPS of "+bestOPS+"\n");
		}
	}

	public static void main(String[] args) {
		ArrayList<Player> allPlayers=dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/MLB2001Hitting.txt");
		EachTeam(allPlayers);
		/*I could have created a HashMap with each team as a key, and an ArrayList of players belonging to that team as
		 *the value, but that would have required me to produce 30 unique ArrayLists. Hence why I instead opted to
		 *produce a set and simply iterate through the one ArrayList of all players. While not as elegant as one single
		 *HashMap object, it is far easier to implement.
		 */
		System.out.println("The total number of players is: "+allPlayers.size()+"\n");
		MostHomeRuns(allPlayers);
	}
}
