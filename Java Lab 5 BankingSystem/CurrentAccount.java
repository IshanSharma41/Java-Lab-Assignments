public class CurrentAccount extends BankAccount {
    private final double overdraftLimit;

    public CurrentAccount(String accountNo, String holderName, double openingBalance, double overdraftLimit)
            throws BankingException {
        super(accountNo, holderName, openingBalance);
        if (overdraftLimit < 0) {
            throw new BankingException("Overdraft limit cannot be negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public String getAccountType() {
        return "CURRENT";
    }

    @Override
    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdraw amount must be positive");
        }
        double remaining = balance - amount;
        if (remaining < -overdraftLimit) {
            throw new BankingException("Overdraft limit exceeded: " + overdraftLimit);
        }
        balance = remaining;
    }
}
