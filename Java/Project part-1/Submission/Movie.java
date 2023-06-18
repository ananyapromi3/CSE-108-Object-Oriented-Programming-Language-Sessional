import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movie {
    String title;
    int yearOfRelease;
    String[] genre = new String[3];
    int runningTime;
    String productionCompany;
    int budget;
    int revenue;

    static List<Movie> movieList = new ArrayList<Movie>();

    public Movie(String line) {
        String[] parts = line.split(",");
        int i = 0;
        this.title = parts[i++];
        this.yearOfRelease = Integer.parseInt(parts[i++]);
        int j = 0;
        while (j < 3) {
            this.genre[j++] = parts[i++];
        }
        this.runningTime = Integer.parseInt(parts[i++]);
        this.productionCompany = parts[i++];
        this.budget = Integer.parseInt(parts[i++]);
        this.revenue = Integer.parseInt(parts[i++]);
    }

    public String getMovieTitle() {
        return this.title;
    }

    public int getYearOfRelease() {
        return this.yearOfRelease;
    }

    public String[] getGenre() {
        return this.genre;
    }

    public String getProductionCompanny() {
        return this.productionCompany;
    }

    public int getRunningTime() {
        return this.runningTime;
    }

    public int getBudget() {
        return this.budget;
    }

    public int getRevenue() {
        return this.revenue;
    }

    public int getProfit() {
        return this.revenue - this.budget;
    }

    static void addMovie(String line) {
        movieList.add(new Movie(line));
    }

    public static int movieCount() {
        return movieList.size();
    }

    public static String getMovieText(int i) {
        return movieList.get(i).getmovie();
    }

    public void showMovie() {
        System.out.println("Movie Name: " + this.title);
        System.out.print("Release Year: ");
        System.out.println(this.yearOfRelease);
        System.out.println("Genre: " + this.genre[0] + ", " + this.genre[1] + ", " + this.genre[2]);
        System.out.print("Movie Duration: ");
        System.out.println(this.runningTime);
        System.out.println("Production Company: " + this.productionCompany);
        System.out.print("Budget: ");
        System.out.println(this.budget);
        System.out.print("Revenue: ");
        System.out.println(this.revenue);
        System.out.println(" ");
    }

    public String getmovie() {
        String movieText = new String(this.title + "," + this.yearOfRelease + "," + this.genre[0] + ","
                + this.genre[1] + "," + this.genre[2] + "," + this.runningTime + "," + this.productionCompany + ","
                + this.budget + "," + this.revenue);
        return movieText;
    }

    public static void searchByMovieTitle(String Title) {
        int k = -1;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getMovieTitle().toLowerCase().equals(Title.toLowerCase())) {
                k = i;
                break;
            }
        }
        if (k < 0) {
            System.out.println("No such movie with this name!");
        } else {
            Movie movie = movieList.get(k);
            movie.showMovie();
        }
    }

    public static void searchByReleaseYear(int year) {
        int k = -1;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getYearOfRelease() == year) {
                k = i;
                movie.showMovie();
            }
        }
        if (k < 0) {
            System.out.println("No such movie with this release year!");
        }
    }

    public static void searchByGenre(String genre) {
        int k = -1;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            for (int j = 0; j < 3; j++) {
                if (movie.getGenre()[j].toLowerCase().equals(genre.toLowerCase())) {
                    k = i;
                    movie.showMovie();
                    break;
                }
            }
        }
        if (k < 0) {
            System.out.println("No such movie with this genre");
        }
    }

    public static void searchByProductionCompany(String productionCompany) {
        int k = -1;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getProductionCompanny().toLowerCase().equals(productionCompany.toLowerCase())) {
                k = i;
                movie.showMovie();
            }
        }
        if (k < 0) {
            System.out.println("No such movie with this production company!");
        }
    }

    public static void searchByRunTime(int runTime_start, int runTime_end) {
        int k = -1;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getRunningTime() <= runTime_end && movie.getRunningTime() >= runTime_start) {
                k = i;
                movie.showMovie();
            }
        }
        if (k < 0) {
            System.out.println("No such movie with this running time range!");
        }
    }

    static void sortByProfit() {
        for (int i = 0; i < movieList.size() - 1; i++) {
            for (int j = 0; j < movieList.size() - i - 1; j++) {
                if (movieList.get(j).getProfit() < movieList.get(j + 1).getProfit()) {
                    Collections.swap(movieList, j, j + 1);
                }
            }
        }
    }

    public static void showTopTenMovies() {
        sortByProfit();
        for (int i = 0; i < 10; i++) {
            movieList.get(i).showMovie();
        }
    }

    static int latestYear(String productionCompany) {
        int temp_year = 0;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getProductionCompanny().toLowerCase().equals(productionCompany.toLowerCase())) {
                if (movie.getYearOfRelease() > temp_year) {
                    temp_year = movie.getYearOfRelease();
                }
            }
        }
        return temp_year;
    }

    public static void mostRecentMovie(String productionCompany) {
        int k = -1;
        int year = latestYear(productionCompany);
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getProductionCompanny().toLowerCase().equals(productionCompany.toLowerCase())
                    && movie.getYearOfRelease() == year) {
                movie.showMovie();
                k = i;
            }
        }
        if (k < 0) {
            System.out.println("No such production company with this name!");
        }
    }

    static int mostRevenue(String productionCompany) {
        int temp_revenue = 0;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getProductionCompanny().toLowerCase().equals(productionCompany.toLowerCase())) {
                if (movie.getRevenue() > temp_revenue) {
                    temp_revenue = movie.getRevenue();
                }
            }
        }
        return temp_revenue;
    }

    public static void mostRevenueMovie(String productionCompany) {
        int k = -1;
        int revenue = mostRevenue(productionCompany);
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getProductionCompanny().toLowerCase().equals(productionCompany.toLowerCase())
                    && movie.getRevenue() == revenue) {
                movie.showMovie();
                k = i;
            }
        }
        if (k < 0) {
            System.out.println("No such production company with this name!");
        }
    }

    public static void totalProfit(String productionCompany) {
        long temp_profit = 0L;
        int k = -1;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getProductionCompanny().toLowerCase().equals(productionCompany.toLowerCase())) {
                k = i;
                temp_profit += movie.getProfit();
            }
        }
        if (k < 0) {
            System.out.println("No such production company with this name!");
        } else {
            System.out.print("Total Profit: ");
            System.out.println(temp_profit);
            System.out.println(" ");
        }
    }

    public static void setProductionCompany() {
        for (int i = 0; i < movieList.size(); i++) {
            ProductionCompany pCompany = new ProductionCompany(movieList.get(i));
        }
    }

    public static boolean checkIfMovieExists(String Title) {
        boolean k = false;
        for (int i = 0; i < movieList.size(); i++) {
            Movie movie = movieList.get(i);
            if (movie.getMovieTitle().toLowerCase().equals(Title.toLowerCase())) {
                k = true;
                break;
            }
        }
        return k;
    }
}
