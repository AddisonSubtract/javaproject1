//Addison Zheng
package javaproject1;

public class main {

	public static void main(String[] args) {
		ShowInWeek s1 = new ShowInWeek("2022-09-04", "Films (English)", "1","Me Time","N/A",56560000,2);
		ShowInWeek s2 = new ShowInWeek("2022-09-04", "Films (English)", "2", "Love in the Villa", "N/A", 41220000, 1);
		ShowInWeek s3 = new ShowInWeek("2022-09-05", "Films (English)", "3", "I Came By", "N/A", 30790000, 1);
		
		AllShows a1 = new AllShows();
		
		a1.addShow(s1);
		a1.addShow(s2);
		a1.addShow(s3);
		
		System.out.println("First Print");
		System.out.println(a1);
		//a1.writeFile("./javaproject1/netflixProcessed");
		
		
		System.out.println("\nRandom Suggestion");
		String randomSug = a1.RandomSuggestion();
		System.out.println(randomSug);
		a1.getShow(randomSug);
		
		System.out.println("\nPredictive Suggestion");
		String pred = a1.PredictiveSuggestion(s3);
		a1.getShow(pred);
		
		System.out.println("\nPurge Test");
		a1.purge("2022-09-05");
		
		System.out.println(a1);
		a1.writeFile("./javaproject1/netflixProcessed");
	}

}
