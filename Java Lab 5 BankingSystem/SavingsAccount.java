public class SavingsAccount extends BankAccount {
    private final double minBalance;
    private final double interestRate;

    public SavingsAccount(String accountNo, String holderName, double openingBalance, double minBalance,
            double interestRate) throws BankingException {
        super(accountNo, holderName, openingBalance);

        if (minBalance < 0) {
            throw new BankingException("Minimum balance cannot be negative");
        }
        if (interestRate < 0) {
            throw new BankingException("Interest rate cannot be negative");
        }
        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdraw amount must be positive");
        }
        double remaining = balance - amount;
        if (remaining < minBalance) {
            throw new BankingException("Minimum balance must be maintained");
        }
        balance = remaining;
    }

    public void applyAnnualInterest() {
        balance += (balance * interestRate / 100);
    }
}