/* Write code that receives the base and height of a rectangle, calculates its area,
and displays it on the screen
formula: area = base × height */

import java.util.Scanner;

public class RectangleAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Rectangle Area Calculator\n");

        System.out.print("Enter the base: ");
        double base = scanner.nextDouble();
        
        System.out.print("Enter the height: ");
        double height = scanner.nextDouble();
        
        double area = base * height;
        
        System.out.println("The area of the rectangle is " + area);
        
        scanner.close();
    }
}