import java.util.Scanner;

public class SearchMovies {
    public static void showMenu() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Movie Searching Options:");
            System.out.println("1) By Movie Title");
            System.out.println("2) By Release Year");
            System.out.println("3) By Genre");
            System.out.println("4) By Production Company");
            System.out.println("5) By Running Time");
            System.out.println("6) Top 10 Movies");
            System.out.println("7) Back to Main Menu");
            String i_s = scan.nextLine();
            int i = Integer.parseInt(i_s);
            if (i == 1) {
                String title = scan.nextLine();
                Movie.searchByMovieTitle(title);
            } else if (i == 2) {
                String year_s = scan.nextLine();
                int year = Integer.parseInt(year_s);
                Movie.searchByReleaseYear(year);
            } else if (i == 3) {
                String genre = scan.nextLine();
                Movie.searchByGenre(genre);
            } else if (i == 4) {
                String productionCompany = scan.nextLine();
                Movie.searchByProductionCompany(productionCompany);
            } else if (i == 5) {
                String runTime_start_s = scan.nextLine();
                int runTime_start = Integer.parseInt(runTime_start_s);
                String runTime_end_s = scan.nextLine();
                int runTime_end = Integer.parseInt(runTime_end_s);
                Movie.searchByRunTime(runTime_start, runTime_end);
            } else if (i == 6) {
                Movie.showTopTenMovies();
            } else if (i == 7) {
                break;
            } else {
                System.out.println("Please enter a valid number");
                continue;
            }
        }
    }
}
