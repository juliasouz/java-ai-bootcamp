/* Write a code where the user provides an initial number, then will enter N other numbers.
The code execution will continue until the number entered divided by the first number
has a remainder different from 0. Numbers smaller than the first number should be ignored. */

import java.util.Scanner;

public class NumberProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Number Processor");
        System.out.println("-----------------");
        
        System.out.print("Enter the initial number: ");
        int initialNumber = scanner.nextInt();
        
        System.out.println("\nNow enter numbers to process (enter 0 to stop):");
        System.out.println("(Numbers smaller than " + initialNumber + " will be ignored)");
        System.out.println("(Program will stop when a number >= " + initialNumber + " is not divisible by " + initialNumber + ")");
        
        int currentNumber;
        boolean continueProcessing = true;
        
        while (continueProcessing) {
            System.out.print("Enter a number: ");
            currentNumber = scanner.nextInt();
            
            if (currentNumber == 0) {
                System.out.println("User requested to stop.");
                continueProcessing = false;
                continue;
            }
            
            if (currentNumber < initialNumber) {
                System.out.println("Ignored (number " + currentNumber + " is smaller than initial number " + initialNumber + ")");
                continue;
            }
            
            if (currentNumber % initialNumber != 0) {
                System.out.println("Stopping condition met (" + currentNumber + " % " + initialNumber + " != 0)");
                continueProcessing = false;
            } else {
                System.out.println("Accepted (" + currentNumber + " % " + initialNumber + " == 0)");
            }
        }
        
        System.out.println("\nProcessing complete!");
        scanner.close();
    }
}