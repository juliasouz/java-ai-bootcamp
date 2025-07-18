/* BankAccount model class: handles only business logic */

public class BankAccountModel {
    private double balance;
    private final double overdraftLimit;
    private double usedOverdraft;
    private final double overdraftFeeRate = 0.20;

    public BankAccountModel(double initialDeposit) {
        this.balance = initialDeposit;
        this.overdraftLimit = initialDeposit <= 500 ? 50 : initialDeposit * 0.5;
        this.usedOverdraft = 0;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getUsedOverdraft() {
        return usedOverdraft;
    }

    public double getAvailableOverdraft() {
        return overdraftLimit - usedOverdraft;
    }

    public double getTotalAvailableFunds() {
        return balance + getAvailableOverdraft();
    }

    public boolean isUsingOverdraft() {
        return usedOverdraft > 0;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        double feeCharged = 0;
        
        if (usedOverdraft > 0) {
            double overdraftPayment = Math.min(amount, usedOverdraft);
            feeCharged = overdraftPayment * overdraftFeeRate;
            amount -= overdraftPayment;
            usedOverdraft -= overdraftPayment;
            balance -= feeCharged;
        }

        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        if (amount > getTotalAvailableFunds()) {
            return false;
        }

        if (amount > balance) {
            usedOverdraft += amount - balance;
            balance = 0;
        } else {
            balance -= amount;
        }

        return true;
    }

    public boolean payBill(double amount) {
        return withdraw(amount);
    }

    public double getLastOverdraftFee(double depositAmount) {
        if (usedOverdraft > 0) {
            double overdraftPayment = Math.min(depositAmount, usedOverdraft);
            return overdraftPayment * overdraftFeeRate;
        }
        return 0;
    }
}
