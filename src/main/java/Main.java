import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    private static String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path)).trim();
    }
    public static void main(String[] args) {
        try {          // ensure output folder exists
            Files.createDirectories(Paths.get("sample_outputs"));

            String[] textFiles = {
                    "data/short.txt",
                    "data/medium.txt",
                    "data/long.txt"
            };

            String pattern = readFile("data/pattern.txt");

            StringBuilder results = new StringBuilder();

            for (String textFile : textFiles) {
                String text = readFile(textFile);
                String testName = textFile.substring(textFile.lastIndexOf("/") + 1);
                // measure
                long start = System.nanoTime();
                List<Integer> occurrences = KMP.search(text, pattern);
                long end = System.nanoTime();

                double timeMs = (end - start) / 1_000_000.0;

                String result = String.format(
                        "--- %s ---\nText length: %d\nPattern length: %d\nOccurrences: %d\nPositions: %s\nTime: %.4f ms\n\n",
                        testName,
                        text.length(),
                        pattern.length(),
                        occurrences.size(),
                        occurrences.size() > 30 ? "[too many]" : occurrences.toString(),
                        timeMs
                );
                System.out.print(result);
                results.append(result);
            }
            Files.writeString(Paths.get("sample_outputs/outputs.txt"), results.toString());
            System.out.println("Results saved to sample_outputs/outputs.txt");
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}




