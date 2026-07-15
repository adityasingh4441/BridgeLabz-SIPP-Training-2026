import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SchoolResultPortal {
    public static double calculateAverage(String[] marks, int startIndex) {
        int total = 0;

        for (int i = startIndex; i < marks.length; i++) {
            total += Integer.parseInt(marks[i]);
        }

        return (double) total / (marks.length - startIndex);
    }

    public static void generateReportCard(String inputFile, String outputFile) {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))
        ) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.trim().split("[,\\s]+");
                String name = data[0];
                double average = calculateAverage(data, 1);

                writer.write("Name: " + name + ", Average Marks: " + average);
                writer.newLine();
            }

            System.out.println("Report card generated successfully");
        } catch (FileNotFoundException exception) {
            System.out.println("Student marks file not found");
        } catch (IOException exception) {
            System.out.println("Error while reading or writing file");
        } catch (NumberFormatException exception) {
            System.out.println("Invalid marks found in file");
        }
    }

    public static void main(String[] args) {
        generateReportCard("students.txt", "report_card.txt");
    }
}
