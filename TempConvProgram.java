import java.util.Scanner;

public class TempConvProgram {

    private static final double FAHRENHEIT_SCALE = 9.0 / 5.0;
    private static final double FAHRENHEIT_OFFSET = 32.0;
    private static final double KELVIN_OFFSET = 273.15;

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * FAHRENHEIT_SCALE + FAHRENHEIT_OFFSET;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - FAHRENHEIT_OFFSET) / FAHRENHEIT_SCALE;
    }

    public static double celsiusToKelvin(double userInput) {
        return userInput + KELVIN_OFFSET;
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("Temperature Conversion Menu");
        System.out.println("1 - Convert Celsius to Fahrenheit");
        System.out.println("2 - Convert Fahrenheit to Celsius");
        System.out.println("3 - Convert Celsius to Kelvin");
        System.out.println("4 - Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    private static int readMenuChoice(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    return choice;
                }
                System.out.print("Invalid choice. Please enter a number between 1 and 4: ");
            } else {
                scanner.next();
                System.out.print("Invalid input. Please enter a number between 1 and 4: ");
            }
        }
    }


    private static double readTemperature(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                scanner.next();
                System.out.print("Invalid temperature. Please enter a numeric value: ");
            }
        }
    }

    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome! Temperature Conversion App");

            while (true) {
                printMenu();
                int choice = readMenuChoice(scanner);

                if (choice == 4) {
                    System.out.println("Exiting...");
                    break;
                }

                double inputTemperature;
                double result;

            switch (choice) {
                case 1:
                    inputTemperature = readTemperature(scanner, "Enter temperature in Celsius: ");
                    result = celsiusToFahrenheit(inputTemperature);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    inputTemperature = readTemperature(scanner, "Enter temperature in Fahrenheit: ");
                    result = fahrenheitToCelsius(inputTemperature);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    inputTemperature = readTemperature(scanner, "Enter temperature in Celsius: ");
                    result = celsiusToKelvin(inputTemperature);
                    System.out.println("Result: " + result);
                    break;
                default:
                    System.out.println(" Invalid choice. Please enter a number between 1 and 4");
            }
        }

    }

}

}
