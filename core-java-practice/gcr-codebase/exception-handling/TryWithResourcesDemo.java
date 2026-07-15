import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesDemo {
    public static void readFirstLine(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println(reader.readLine());
        } catch (IOException exception) {
            System.out.println("Error reading file");
        }
    }

    public static void main(String[] args) {
        readFirstLine("info.txt");
    }
}
