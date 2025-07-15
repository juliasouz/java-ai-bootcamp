/* Write a code that receives the name and age of 2 people
and prints the age difference between them */

import java.util.Scanner;

public class AgeDifferenceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Age Difference Calculator");
        
        System.out.print("Enter first person's name: ");
        String name1 = scanner.nextLine();
        System.out.print("Enter first person's age: ");
        int age1 = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter second person's name: ");
        String name2 = scanner.nextLine();
        System.out.print("Enter second person's age: ");
        int age2 = scanner.nextInt();
        
        int difference = Math.abs(age1 - age2);
        
        System.out.println("The age difference between " + name1 + " and " + name2 + " is " + difference + " years!");
        
        scanner.close();
    }
}