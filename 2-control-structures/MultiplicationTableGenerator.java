/* Write a code where the user enters a number and the multiplication table
from 1 to 10 for that number is generated. */

import java.util.Scanner;

public class MultiplicationTableGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Multiplication Table Generator");
        System.out.println("-----------------------------\n");
        
        System.out.print("Enter a number to generate its multiplication table (1-10): ");
        int number = scanner.nextInt();
        
        System.out.println("\nMultiplication Table for " + number + ":");
        System.out.println("--------------------------");
        
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d x %2d = %3d\n", number, i, number * i);
        }
        
        scanner.close();
    }
}