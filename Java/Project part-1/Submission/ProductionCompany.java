public class ProductionCompany {
    String name;
    int movieCount;
    Movie movie[] = new Movie[500];

    static ProductionCompany productionCompanies[] = new ProductionCompany[500];
    static int productionCompanyCount = 0;

    public ProductionCompany(Movie movie) {
        this.name = movie.getProductionCompanny();
        this.movieCount = 1;
        int flag = 0;
        for (int i = 0; i < productionCompanyCount; i++) {
            if (movie.getProductionCompanny().toLowerCase().equals(productionCompanies[i].getName().toLowerCase())) {
                flag = 1;
                productionCompanies[i].movieCount++;
            }
        }
        if (flag == 0) {
            productionCompanies[productionCompanyCount++] = this;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMovieCount() {
        return this.movieCount;
    }

    static void showProductionCompany(ProductionCompany pCompany) {
        if (!pCompany.getName().equals("")) {
            System.out.println(
                    "Production Company: " + pCompany.getName() + "    Total Movies: " + pCompany.getMovieCount());
        }
    }

    public static void showCompaniesInfo() {
        System.out.println(productionCompanyCount);
        for (int i = 0; i < productionCompanyCount; i++) {
            showProductionCompany(productionCompanies[i]);
        }
    }
}
