package javaproject1;

import java.io.*;
import java.util.*;

public class AllShows {
	private int size = 0;
	private static final int DEFAULT_SIZE = 100000;
	private ShowInWeek[] allShows;
	private String fileName;
	Random rand = new Random();
	private ArrayList<ShowInWeek> showList;


	Scanner input = new Scanner(System.in);

	public AllShows() {
		allShows = new ShowInWeek[DEFAULT_SIZE];
		showList = new ArrayList<ShowInWeek>();
		fileName = "./javaproject1/netflixTopTenProcessed.txt";
		readFile();
	}

	public void addShow(ShowInWeek s) {
		allShows[size] = s;
		showList.add(s);
		size++;
	}
	
	public void getShow(String week) {
		for(ShowInWeek s: showList)
		{
			if(s.getWeek().equals(week))
			{
				System.out.println(s.getWeek());
				System.out.println(s.getCategory());
				System.out.println(s.getWeeklyRank());
				System.out.println(s.getShowTitle());
				System.out.println(s.getSeasonTitle());
				System.out.println(s.getWeeklyHours());
				System.out.println(s.getWeeksInTop10());
				break;
			}else {
				System.out.println("Show does not exist, try again.");
				break;
			}
		}
	}

	public void purge(String week) {
		for(ShowInWeek s: showList)
		{
			if(s.getWeek().equals(week))
			{
				s.setWeek("*" + week);
				s.setPurge(true);
			}
		}
	}

	public void unpurge(String week) {
		for(ShowInWeek s: showList)
		{
			if(s.getPurge() == true)
			{
				s.setWeek(week);
				s.setPurge(false);
			}
		}
	}

	public String RandomSuggestion() {
		String zeroMonth = "", zeroDay = "";
		int year = rand.nextInt((2022 - 2021) + 1) + 2021;
		int month = rand.nextInt((12 - 1) + 1) + 1;
		int day = rand.nextInt((31 - 1) + 1) + 1;

		if(month < 10) {
			zeroMonth = "0" + month;
		}else {
			zeroMonth += month;
		}
		if(day < 10) {
			zeroDay = "0" + day;
		}else {
			zeroDay += day;
		}

		String week = year + "-" + zeroMonth + "-" + zeroDay;

		return week;
	}

	public String PredictiveSuggestion(ShowInWeek s) {
		for(int i = 0; i < DEFAULT_SIZE; i++)
		{
			if(allShows[i].equals(s))
			{
				return allShows[i-1].getWeek();
			}
		}
		return "Unable to Recommend";
		
	}

	public String toString() {
		String toReturn = "";
		for(int i = 0; i < size; i++)
		{
			if(allShows[i].getPurge() == true) {
				toReturn += "\nPurged\n";
			}else {
				toReturn += allShows[i] + "\n";
			}
		}
		return toReturn;
	}

	private void readFile () {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line = null;
			while ((line = lineReader.readLine())!=null) {
				String week = line;
				String category = lineReader.readLine();
				String weeklyRank = lineReader.readLine();
				String showTitle = lineReader.readLine();
				String seasonTitle = lineReader.readLine();
				String weeklyHours = lineReader.readLine();
				String week10 = lineReader.readLine();

				addShow(new ShowInWeek(week, category, weeklyRank, showTitle, seasonTitle,Integer.parseInt(weeklyHours), Integer.parseInt(week10)));
			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String line = null;
				while ((line = lineReader.readLine())!=null) {
					String week = lineReader.readLine();
					String category = lineReader.readLine();
					String weeklyRank = lineReader.readLine();
					String showTitle = lineReader.readLine();
					String seasonTitle = lineReader.readLine();
					String weeklyHours = lineReader.readLine();
					String week10 = lineReader.readLine();
				}
			} catch (Exception e2) {
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	}

	public void writeFile () {
		// overloaded method: this calls doWrite with file used to read data
		// use this for saving data between runs
		doWrite(fileName);
	} // end of writeFile method

	public void writeFile(String altFileName) {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite(altFileName);		
	}// end of writeFile method

	private void doWrite(String fn) {
		// this method writes all of the data in the persons array to a file
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			

			for (int i = 0; i < size; i++) {
				ShowInWeek show = allShows[i];
				myOutfile.write (show.getWeek()+"\n");
				myOutfile.write (show.getCategory()+"\n");
				myOutfile.write (show.getWeeklyRank()+"\n");
				myOutfile.write (show.getShowTitle()+"\n");
				myOutfile.write (show.getSeasonTitle()+"\n");
				myOutfile.write (show.getWeeklyHours()+"\n");
				myOutfile.write (show.getWeeksInTop10()+"\n");
			}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}	

}