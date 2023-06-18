import java.util.Scanner;

public class SearchProductionCompany {
    public static void showMenu() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Production Company Searching Options:");
            System.out.println("1) Most Recent Movies");
            System.out.println("2) Movies with the Maximum Revenue");
            System.out.println("3) Total Profit");
            System.out.println("4) List of Production Companies and the Count of their Produced Movies");
            System.out.println("5) Back to Main Menu");
            String i_s = scan.nextLine();
            int i = Integer.parseInt(i_s);
            if (i == 1) {
                String productionCompany = scan.nextLine();
                Movie.mostRecentMovie(productionCompany);
            } else if (i == 2) {
                String productionCompany = scan.nextLine();
                Movie.mostRevenueMovie(productionCompany);
            } else if (i == 3) {
                String productionCompany = scan.nextLine();
                Movie.totalProfit(productionCompany);
            } else if (i == 4) {
                Movie.setProductionCompany();
                ProductionCompany.showCompaniesInfo();
            } else if (i == 5) {
                break;
            } else {
                System.out.println("Please enter a valid number");
                continue;
            }
        }
    }
}
