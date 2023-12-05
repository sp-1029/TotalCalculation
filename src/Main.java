import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double subtotal = 0;
        File items = new File("items.txt");
        File totalFile = new File("total.txt");
        try {
            Scanner reader = new Scanner(items);
            while (reader.hasNextDouble()) {
                subtotal += reader.nextDouble();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        subtotal *= 100;
        double tax = (subtotal * 0.053);
        double totalMoney = (subtotal + tax);
        subtotal = (double) Math.round(subtotal) / 100;
        tax = (double) Math.round(tax) / 100;
        totalMoney = (double) Math.round(totalMoney) / 100;
        try {
            FileWriter fw = new FileWriter(totalFile);
            fw.write("The sub-total is $" + subtotal + '\n' + "The tax is $" + tax + '\n' + "The total is $" + totalMoney);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}