package javaproject1;

public class ShowInWeek {
	
	private String week;
	private String category;
	private String weeklyRank;
	private String showTitle;
	private String seasonTitle;
	private int weeklyHours;
	private int weeksInTop10;
	private boolean purge;

	//Default Constructor
	public ShowInWeek() {
		week = "not set";
		category = "not set";
		weeklyRank = "not set";
		showTitle = "not set";
		seasonTitle = "not set";
		weeklyHours = 0;
		weeksInTop10 = 0;
		purge = false;
	}
	
	//Constructor
	public ShowInWeek(String w, String c, String r,String s, String t, int h, int i) {
		week = w;
		category = c;
		weeklyRank = r;
		showTitle = s;
		seasonTitle = t;
		weeklyHours = h;
		weeksInTop10 = i;
	}
	
	//Sets week
	public void setWeek(String w) {
		week = w;
	}
	
	//Sets category
	public void setCategory(String c) {
		category = c;
	}
	
	//Sets weekly ranks
	public void setWeeklyRank(String r) {
		weeklyRank = r;
	}
	
	//Sets show title
	public void setShowTitle(String s) {
		showTitle = s;
	}
	
	//Sets season title
	public void setSeasonTitle(String t) {
		seasonTitle = t;
	}
	
	//Sets weekly hours
	public void setWeeklyHours(int h) {
		weeklyHours = h;
	}
	
	//Sets weeks in top 10
	public void setWeeksInTop10(int i) {
		weeksInTop10 = i;
	}
	
	//Sets purge status
	public void setPurge(boolean p) {
		purge = p;
	}
	
	//Returns week
	public String getWeek() {
		return week;
	}
	
	//Returns category
	public String getCategory() {
		return category;
	}
	
	//Returns weekly rank
	public String getWeeklyRank() {
		return weeklyRank;
	}
	
	//Returns show title
	public String getShowTitle() {
		return showTitle;
	}
	
	//Returns season title
	public String getSeasonTitle() {
		return seasonTitle;
	}
	
	//Returns weekly hours
	public int getWeeklyHours() {
		return weeklyHours;
	}
	
	//Returns weeks in top 10
	public int getWeeksInTop10() {
		return weeksInTop10;
	}
	
	//Returns purge status
	public boolean getPurge() {
		return purge;
	}
	
	//Outputs the data in a readable fashion
	public String toString() {
		return week + "\n" + category + "\n" + weeklyRank + "\n" 
				+ showTitle + "\n" + seasonTitle + "\n" + weeklyHours + "\n" +weeksInTop10;
	}
}