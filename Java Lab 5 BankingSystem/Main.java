import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            // Create Accounts (Polymorphism)
            BankAccount acc1 = new SavingsAccount("SA101", "Jay", 50000, 20000, 5);
            BankAccount acc2 = new CurrentAccount("CA201", "Rahul", 20000, 3000);
            BankAccount acc3 = new BankAccount("BA301", "Aman", 15000);

            // Store in ArrayList
            ArrayList<BankAccount> accounts = new ArrayList<>();
            accounts.add(acc1);
            accounts.add(acc2);
            accounts.add(acc3);

            // Initial State
            System.out.println("----- Initial Accounts -----");
            printAll(accounts);

            // Deposit in all accounts
            System.out.println("\n----- Depositing 1000 in all accounts -----");
            for (BankAccount acc : accounts) {
                acc.deposit(1000);
            }
            printAll(accounts);

            // Withdraw (shows different behavior)
            System.out.println("\n----- Withdraw Operations -----");

            acc1.withdraw(2000); // Savings rule (min balance)
            acc2.withdraw(4000); // Current rule (overdraft)
            acc3.withdraw(500); // Normal rule

            printAll(accounts);

        } catch (BankingException e) {
            System.out.println("Banking Error: " + e.getMessage());
        }
    }

    // Helper method to display all accounts
    public static void printAll(ArrayList<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            System.out.println(acc.summary());
        }
    }
}