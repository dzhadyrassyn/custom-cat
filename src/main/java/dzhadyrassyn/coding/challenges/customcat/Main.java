package dzhadyrassyn.coding.challenges.customcat;

import java.io.*;
import java.nio.file.NoSuchFileException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new NoSuchFileException("File name should be provided");
        } else if (args.length == 1 && args[0].equals("-")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } else {
            for (String fileName : args) {
                File file = new File(fileName);
                if (!file.isFile()) {
                    throw new NoSuchFileException("Not such file: " + fileName);
                } else if (!fileName.endsWith("txt")) {
                    throw new WrongFileFormatExtension("File should be in txt format");
                }
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
            }
        }
    }
}