/* Write code where the user enters their height and weight,
the calculation of their BMI is performed (BMI = weight/(height * height)),
and a message is displayed according to the result:

    If it is less than or equal to 18.5 "Underweight";
    If it is between 18.6 and 24.9 "Ideal weight";
    If it is between 25.0 and 29.9 "Slightly overweight";
    If it is between 30.0 and 34.9 "Obesity Class I";
    If it is between 35.0 and 39.9 "Obesity Class II (Severe)";
    If it is greater than or equal to 40.0 "Obesity Class III (Morbid)"; */

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("BMI Calculator");
        System.out.println("-------------");
        
        System.out.print("Enter your weight in kg (e.g., 68.5): ");
        double weight = scanner.nextDouble();
        
        System.out.print("Enter your height in meters (e.g., 1.75): ");
        double height = scanner.nextDouble();
        
        double bmi = weight / (height * height);
        
        System.out.printf("\nYour BMI is: %.2f\n", bmi);
        System.out.print("Classification: ");
        
        if (bmi <= 18.5) {
            System.out.println("Underweight");
        } else if (bmi <= 24.9) {
            System.out.println("Normal weight");
        } else if (bmi <= 29.9) {
            System.out.println("Overweight");
        } else if (bmi <= 34.9) {
            System.out.println("Obesity Class I");
        } else if (bmi <= 39.9) {
            System.out.println("Obesity Class II (Severe)");
        } else {
            System.out.println("Obesity Class III (Morbid)");
        }
        
        scanner.close();
    }
}