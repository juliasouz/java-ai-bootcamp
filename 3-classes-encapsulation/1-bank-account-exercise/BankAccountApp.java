/*
 * Main application class: handles user interface and interaction
 * Uses BankAccountModel for business logic
 */

import java.util.Scanner;

public class BankAccountApp {
    private final Scanner scanner;
    private BankAccountModel account;

    public BankAccountApp() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter initial deposit: R$ ");
        double initialDeposit = scanner.nextDouble();
        account = new BankAccountModel(initialDeposit);
        
        System.out.printf("Account created with initial deposit: R$ %.2f%n", initialDeposit);
        System.out.printf("Overdraft limit: R$ %.2f%n", account.getOverdraftLimit());
        
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n************** BANK ACCOUNT MENU **************");
            System.out.println("1. Check Balance");
            System.out.println("2. Check Overdraft");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Pay Bill");
            System.out.println("6. Check Overdraft Usage");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            int option = scanner.nextInt();
            
            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    checkOverdraft();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    payBill();
                    break;
                case 6:
                    checkOverdraftUsage();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please try again");
            }
        }
    }

    private void checkBalance() {
        System.out.printf("Current balance: R$ %.2f%n", account.getBalance());
        System.out.printf("Total available funds: R$ %.2f%n", account.getTotalAvailableFunds());
    }

    private void checkOverdraft() {
        System.out.printf("Overdraft limit: R$ %.2f%n", account.getOverdraftLimit());
        System.out.printf("Available overdraft: R$ %.2f%n", account.getAvailableOverdraft());
        System.out.printf("Used overdraft: R$ %.2f%n", account.getUsedOverdraft());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: R$ ");
        double amount = scanner.nextDouble();
        
        double feeCharged = account.getLastOverdraftFee(amount);
        
        if (account.deposit(amount)) {
            if (feeCharged > 0) {
                System.out.printf("Overdraft fee charged: R$ %.2f%n", feeCharged);
            }
            System.out.printf("Deposited R$ %.2f successfully!%n", amount);
            System.out.printf("New balance: R$ %.2f%n", account.getBalance());
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: R$ ");
        double amount = scanner.nextDouble();
        
        if (account.withdraw(amount)) {
            System.out.printf("Withdrew R$ %.2f successfully!%n", amount);
            System.out.printf("New balance: R$ %.2f%n", account.getBalance());
            if (account.isUsingOverdraft()) {
                System.out.printf("Using overdraft: R$ %.2f%n", account.getUsedOverdraft());
            }
        } else {
            System.out.println("Transaction failed! Insufficient funds or invalid amount.");
        }
    }

    private void payBill() {
        System.out.print("Enter bill amount: R$ ");
        double amount = scanner.nextDouble();
        
        if (account.payBill(amount)) {
            System.out.printf("Bill of R$ %.2f paid successfully!%n", amount);
            System.out.printf("New balance: R$ %.2f%n", account.getBalance());
            if (account.isUsingOverdraft()) {
                System.out.printf("Using overdraft: R$ %.2f%n", account.getUsedOverdraft());
            }
        } else {
            System.out.println("Payment failed! Insufficient funds or invalid amount.");
        }
    }

    private void checkOverdraftUsage() {
        if (account.isUsingOverdraft()) {
            System.out.printf("Currently using overdraft: R$ %.2f%n", account.getUsedOverdraft());
            System.out.printf("Available overdraft remaining: R$ %.2f%n", account.getAvailableOverdraft());
        } else {
            System.out.println("Not using overdraft - account is in good standing!");
        }
    }

    public static void main(String[] args) {
        BankAccountApp app = new BankAccountApp();
        app.start();
    }
}
