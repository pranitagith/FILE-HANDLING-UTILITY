import java.io.*;
import java.util.Scanner;

public class FileOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "sample.txt";

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Read file");
            System.out.println("2. Write to file");
            System.out.println("3. Modify file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    readFile(fileName);
                    break;
                case 2:
                    writeFile(fileName, scanner);
                    break;
                case 3:
                    modifyFile(fileName, scanner);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to read a file
    private static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to write to a file
    private static void writeFile(String fileName, Scanner scanner) {
        System.out.print("Enter text to write to the file: ");
        String text = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);
            System.out.println("Text written to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to modify a file
    private static void modifyFile(String fileName, Scanner scanner) {
        System.out.print("Enter text to append to the file: ");
        String text = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.newLine(); // Add a new line before appending
            writer.write(text);
            System.out.println("Text appended to the file successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}