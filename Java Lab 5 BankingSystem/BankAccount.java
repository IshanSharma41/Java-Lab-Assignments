public class BankAccount {
    private final String accountNo;
    private final String holderName;
    protected double balance;

    public BankAccount(String accountNo, String holderName, double openingBalance) throws BankingException {
        if (accountNo == null || accountNo.isBlank()) {
            throw new BankingException("Account number cannot be empty");
        }
        if (holderName == null || holderName.isBlank()) {
            throw new BankingException("Holder name cannot be empty");
        }
        if (openingBalance < 0) {
            throw new BankingException("Opening balance cannot be negative");
        }

        this.accountNo = accountNo;
        this.holderName = holderName;
        this.balance = openingBalance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws BankingException {
    if (amount <= 0) {
        throw new BankingException("Deposit amount must be positive");
    }
    balance += amount;   // ✅ CORRECT
}

    public void withdraw(double amount) throws BankingException {
        if (amount <= 0) {
            throw new BankingException("Withdraw amount must be positive");
        }
        if (amount > balance) {
            throw new BankingException("Insufficient balance");
        }
        balance -= amount;
    }

    public String getAccountType() {
        return "GENRIC";
    }

    public String summary() {
        return String.format("[%s] AccNo=%s, Holder=%s, Balance=%.2f", getAccountType(), accountNo, holderName,
                balance);
    }
}