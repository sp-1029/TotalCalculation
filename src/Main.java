import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("items.txt");
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write("woah I really work\n");
        } catch (IOException e) {
            System.out.println("Damn you schitzo that file doesn't exist");
        }

        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))) {
            System.out.println(scanner.nextLine());
        } catch (IOException e) {

        }
    }
}