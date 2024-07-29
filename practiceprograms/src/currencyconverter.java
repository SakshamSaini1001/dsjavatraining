
import java.util.Scanner;

public class currencyconverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");
        System.out.println("1. Convert INR to USD");
        System.out.println("2. Convert USD to INR");
        System.out.println("3. Quit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                convertInrToUsd();
                break;
            case 2:
                convertUsdToInr();
                break;
            case 3:
                System.out.println("Thank you");
                // Close the scanner
                scanner.close();
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void convertUsdToInr() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount in USD: ");
        double usdAmount = scanner.nextDouble();
        //multiply the today coversion rate with usd
        double inrAmount = usdAmount * 83.5;
        System.out.println(usdAmount + " USD is equivalent to " + inrAmount + " INR");
    }

    private static void convertInrToUsd() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount in INR: ");
        double inrAmount = scanner.nextDouble();
        //divide the today coversion rate of usd
        double usdAmount = inrAmount / 83.5;
        System.out.println(inrAmount + " INR is equivalent to " + usdAmount + " USD");

    }
}