import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFromFile {
    final String INPUT_FILE_NAME;

    public ReadFromFile(String inputFileName) throws Exception {
        this.INPUT_FILE_NAME = inputFileName;
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) {
                break;
            }
            Movie.addMovie(line);
        }
        br.close();
    }
}
