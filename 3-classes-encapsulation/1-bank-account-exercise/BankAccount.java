/* 
    Write a code for a bank account that can perform the following operations:
        Check balance
        Check overdraft
        Deposit money
        Withdraw money
        Pay a bill
        Check if the account is using overdraft

Follow these rules for implementation:

    The bank account must have an overdraft limit added to the account balance;
    The overdraft limit is defined at the time of account creation, according to the amount deposited when opening the account;
    If the initial deposit is R$500.00 or less, the overdraft limit should be R$50.00;
    For amounts above R$500.00, the overdraft limit should be 50% of the deposited amount;
    If the overdraft limit is used, as soon as possible the account must charge a fee of 20% on the amount of overdraft used.
 */
import java.util.Scanner;

public class BankAccount {
    private double balance;
    private final double overdraftLimit;
    private double usedOverdraft;
    private final double overdraftFeeRate = 0.20;

    public BankAccount(double initialDeposit) {
        this.balance = initialDeposit;
        this.overdraftLimit = initialDeposit <= 500 ? 50 : initialDeposit * 0.5;
        this.usedOverdraft = 0;
    }

    // Account operations
    public void checkBalance() {
        System.out.printf("Current balance: R$ %.2f%n", balance);
    }

    public void checkOverdraft() {
        System.out.printf("Overdraft limit: R$ %.2f | Available: R$ %.2f%n", overdraftLimit, overdraftLimit - usedOverdraft);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
            return;
        }

        if (usedOverdraft > 0) {
            double remainingOverdraft = Math.min(amount, usedOverdraft);
            double fee = remainingOverdraft * overdraftFeeRate;
            amount -= remainingOverdraft;
            usedOverdraft -= remainingOverdraft;
            balance -= fee;
            System.out.printf("Overdraft fee charged: R$ %.2f%n", fee);
        }

        balance += amount;
        System.out.printf("Deposited R$ %.2f | New balance: R$ %.2f%n", amount, balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
            return;
        }

        double availableFunds = balance + (overdraftLimit - usedOverdraft);
        if (amount > availableFunds) {
            System.out.println("Insufficient funds!");
            return;
        }

        if (amount > balance) {
            usedOverdraft += amount - balance;
            balance = 0;
        } else {
            balance -= amount;
        }

        System.out.printf("Withdrew R$ %.2f%n", amount);
        checkBalance();
    }

    public void payBill(double amount) {
        withdraw(amount);
    }

    public void checkOverdraftUsage() {
        if (usedOverdraft > 0) {
            System.out.printf("Using overdraft: R$ %.2f%n", usedOverdraft);
        } else {
            System.out.println("Not using overdraft");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter initial deposit: R$ ");
        BankAccount account = new BankAccount(scanner.nextDouble());
        
        while (true) {
            System.out.println("\n1. Check Balance");
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
                    account.checkBalance();
                    break;
                case 2:
                    account.checkOverdraft();
                    break;
                case 3:
                    System.out.print("Enter deposit amount: R$ ");
                    account.deposit(scanner.nextDouble());
                    break;
                case 4:
                    System.out.print("Enter withdrawal amount: R$ ");
                    account.withdraw(scanner.nextDouble());
                    break;
                case 5:
                    System.out.print("Enter bill amount: R$ ");
                    account.payBill(scanner.nextDouble());
                    break;
                case 6:
                    account.checkOverdraftUsage();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}