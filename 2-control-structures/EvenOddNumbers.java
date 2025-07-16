import java.util.Scanner;

public class EvenOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Even and Odd Numbers Generator");
        System.out.println("-------------------------------\n");
        
        int firstNumber, secondNumber;
        do {
            System.out.print("Enter the first number: ");
            firstNumber = scanner.nextInt();
            
            System.out.print("Enter the second number (must be greater than the first): ");
            secondNumber = scanner.nextInt();
            
            if (secondNumber <= firstNumber) {
                System.out.println("Error: Second number must be greater than the first! Try again.\n");
            }
        } while (secondNumber <= firstNumber);
        
        String choice;
        do {
            System.out.print("Choose (E)ven or (O)dd: ");
            choice = scanner.next().toUpperCase();
            
            if (!choice.equals("E") && !choice.equals("O")) {
                System.out.println("Invalid choice! Please enter 'E' or 'O'.\n");
            }
        } while (!choice.equals("E") && !choice.equals("O"));
        
        System.out.println("\nNumbers in descending order:");
        System.out.println("---------------------------\n");
        
        int count = 0;
        for (int i = secondNumber; i >= firstNumber; i--) {
            if ((choice.equals("E") && i % 2 == 0) || (choice.equals("O") && i % 2 != 0)) {
                System.out.printf("%3d", i);
                count++;
                
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
        }
        
        System.out.println("\n\nTotal " + (choice.equals("E") ? "even" : "odd") + " numbers found: " + count);
        
        scanner.close();
    }
}