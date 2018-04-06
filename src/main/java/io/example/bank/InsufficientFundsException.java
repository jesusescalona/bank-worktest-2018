package io.example.bank;


public class InsufficientFundsException extends BusinessException {
    private final String accountRef;

    public InsufficientFundsException(String accountRef) {
        super("Insufficient funds '" + accountRef + "'");
        this.accountRef = accountRef;
    }

    public String getAccountRef() {
        return accountRef;
    }
}
