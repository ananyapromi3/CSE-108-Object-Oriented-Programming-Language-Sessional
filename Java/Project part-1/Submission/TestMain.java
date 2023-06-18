public class TestMain {
    public static void main(String[] args) throws Exception {
        ReadFromFile readFromFile = new ReadFromFile("movies.txt");
        MainMenu.showMenu();
        WriteOnFile writeOnFile = new WriteOnFile("movies.txt");
    }
}
