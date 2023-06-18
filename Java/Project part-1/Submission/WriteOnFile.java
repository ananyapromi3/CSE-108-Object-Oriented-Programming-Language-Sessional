import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteOnFile {
    final String OUTPUT_FILE_NAME;

    public WriteOnFile(String outputFileName) throws Exception {
        this.OUTPUT_FILE_NAME = outputFileName;
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for (int i = 0; i < Movie.movieCount(); i++) {
            String text = Movie.getMovieText(i);
            bw.write(text);
            bw.write(System.lineSeparator());
        }
        bw.close();
    }
}
