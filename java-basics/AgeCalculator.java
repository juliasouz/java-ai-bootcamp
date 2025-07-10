/* Exercise: Write a Java code that receives a person's name and year of birth,
then prints the following message on the screen:
"Hello 'Name', you are 'X' years old" */

import java.util.Scanner;
import java.time.Year;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your birth year: ");
        int birthYear = scanner.nextInt();
        
        int currentYear = Year.now().getValue();
        int age = currentYear - birthYear;
        
        System.out.println("Hello '" + name + "', you are '" + age + "' years old");
        
        scanner.close();
    }
}