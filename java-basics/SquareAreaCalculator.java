/* Write a program that receives the side length of a square as input and
calculates its area using the formula: area = side × side
Then displays the result on the screen*/

import java.util.Scanner;

public class SquareAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the length of the square's side: ");
        double side = scanner.nextDouble();
        
        double area = side * side;
        
        System.out.println("The area of the square is " + area);
        
        scanner.close();
    }
}