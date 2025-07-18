public class BankAccountTest {
    
    public static void main(String[] args) {
        System.out.println("************** TESTING BANK ACCOUNT MODEL **************\n");
        
        // Test 1: Account creation with low initial deposit
        System.out.println("Test 1: Account with R$ 300 initial deposit");
        BankAccountModel account1 = new BankAccountModel(300);
        System.out.printf("Balance: R$ %.2f%n", account1.getBalance());
        System.out.printf("Overdraft Limit: R$ %.2f%n", account1.getOverdraftLimit());
        
        // Test 2: Account creation with high initial deposit
        System.out.println("\nTest 2: Account with R$ 1000 initial deposit");
        BankAccountModel account2 = new BankAccountModel(1000);
        System.out.printf("Balance: R$ %.2f%n", account2.getBalance());
        System.out.printf("Overdraft Limit: R$ %.2f%n", account2.getOverdraftLimit());
        
        // Test 3: Deposit operation
        System.out.println("\nTest 3: Deposit R$ 200 to first account");
        account1.deposit(200);
        System.out.printf("New Balance: R$ %.2f%n", account1.getBalance());
        
        // Test 4: Withdrawal within balance
        System.out.println("\nTest 4: Withdraw R$ 100 from first account");
        boolean success = account1.withdraw(100);
        System.out.printf("Withdrawal successful: %b%n", success);
        System.out.printf("New Balance: R$ %.2f%n", account1.getBalance());
        
        // Test 5: Withdrawal using overdraft
        System.out.println("\nTest 5: Withdraw R$ 450 (using overdraft)");
        success = account1.withdraw(450);
        System.out.printf("Withdrawal successful: %b%n", success);
        System.out.printf("Balance: R$ %.2f%n", account1.getBalance());
        System.out.printf("Used Overdraft: R$ %.2f%n", account1.getUsedOverdraft());
        System.out.printf("Is using overdraft: %b%n", account1.isUsingOverdraft());
        
        // Test 6: Deposit to pay back overdraft (with fee)
        System.out.println("\nTest 6: Deposit R$ 100 (should pay overdraft fee)");
        double feeExpected = account1.getLastOverdraftFee(100);
        System.out.printf("Expected overdraft fee: R$ %.2f%n", feeExpected);
        account1.deposit(100);
        System.out.printf("New Balance: R$ %.2f%n", account1.getBalance());
        System.out.printf("Used Overdraft: R$ %.2f%n", account1.getUsedOverdraft());
        
        // Test 7: Invalid operations
        System.out.println("\nTest 7: Invalid operations");
        boolean invalidDeposit = account1.deposit(-50);
        boolean invalidWithdraw = account1.withdraw(-100);
        boolean insufficientFunds = account1.withdraw(1000);
        System.out.printf("Invalid deposit result: %b%n", invalidDeposit);
        System.out.printf("Invalid withdraw result: %b%n", invalidWithdraw);
        System.out.printf("Insufficient funds result: %b%n", insufficientFunds);
        
        System.out.println("\n************** ALL TESTS COMPLETED **************");
    }
}
