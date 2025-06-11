import java.util.Scanner;

public class cal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        // Display menu2
        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Multiplication");
        System.out.println("3. Division");
        System.out.println("4. Subtraction");

        // Read user choice
        choice = sc.nextInt();

        // Perform operation based on choice
        switch (choice) {
            case 1:
                addition();
                break;
            case 2:
                multiplication();
                break;
            case 3:
                division();
                break;
            case 4:
                subtraction();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }

    // Method for addition
    public static void addition() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers to add (comma separated):");
        String[] input = sc.next().split(",");
        int sum = 0;
        for (String number : input) {
            sum += Integer.parseInt(number.trim());
        }
        System.out.println("Result: " + sum);
    }

    // Method for multiplication
    public static void multiplication() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers to multiply (comma separated):");
        String[] input = sc.next().split(",");
        int product = 1;
        for (String number : input) {
            product *= Integer.parseInt(number.trim());
        }
        System.out.println("Result: " + product);
    }

    // Method for division
    public static void division() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers to divide (a / b):");
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (b != 0) {
            System.out.println("Result: " + (a / b));
        } else {
            System.out.println("Error: Cannot divide by zero.");
        }
    }

    // ✅ Method for subtraction
    public static void subtraction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers to subtract (comma separated):");
        String[] input = sc.next().split(",");
        if (input.length == 0) {
            System.out.println("No numbers provided.");
            return;
        }
        int result = Integer.parseInt(input[0].trim());
        for (int i = 1; i < input.length; i++) {
            result -= Integer.parseInt(input[i].trim());
        }
        System.out.println("Result: " + result);
    }
}
