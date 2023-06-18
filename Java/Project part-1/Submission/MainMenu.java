import java.util.Scanner;

public class MainMenu {
    public static void showMenu() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1) Search Movies");
            System.out.println("2) Search Production Companies");
            System.out.println("3) Add Movie");
            System.out.println("4) Exit System");
            String i_s = scan.nextLine();
            int i = Integer.parseInt(i_s);
            if (i == 1) {
                SearchMovies.showMenu();
            } else if (i == 2) {
                SearchProductionCompany.showMenu();
            } else if (i == 3) {
                StringBuffer movieLine = new StringBuffer("");
                System.out.print("Enter movie title: ");
                String str = scan.nextLine();
                if (Movie.checkIfMovieExists(str)) {
                    System.out.println("Sorry, this movie already exists!");
                } else {
                    movieLine.append(str + ",");
                    System.out.print("Enter movie's release year: ");
                    str = scan.nextLine();
                    movieLine.append(str + ",");
                    System.out.print("How many genre you want to include? ");
                    str = scan.nextLine();
                    int genreCount = Integer.parseInt(str);
                    for (int j = 0; j < 3; j++) {
                        if (j < genreCount) {
                            System.out.print("Enter genre-" + j + ": ");
                            str = scan.nextLine();
                            movieLine.append(str + ",");
                        } else {
                            movieLine.append(",");
                        }
                    }
                    System.out.print("Enter movie's running time: ");
                    str = scan.nextLine();
                    movieLine.append(str + ",");
                    System.out.print("Enter movie's production company: ");
                    str = scan.nextLine();
                    movieLine.append(str + ",");
                    System.out.print("Enter movie's budget: ");
                    str = scan.nextLine();
                    movieLine.append(str + ",");
                    System.out.print("Enter movie's revenue: ");
                    str = scan.nextLine();
                    movieLine.append(str);
                    Movie.addMovie(movieLine.toString());
                }
            } else if (i == 4) {
                break;
            } else {
                System.out.println("Please enter a valid number");
                continue;
            }
        }
    }
}
