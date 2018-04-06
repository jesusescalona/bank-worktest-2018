package io.example.bank;

import java.io.Serializable;


public final class LedgerEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String accountRef;

    private final Money amount;

    public LedgerEntry(String accountRef, Money amount) {
        if (accountRef == null) {
            throw new NullPointerException("accountRef is null");
        }
        if (amount == null) {
            throw new NullPointerException("amount is null");
        }
        this.accountRef = accountRef;
        this.amount = amount;
    }

    public Money getAmount() {
        return amount;
    }

    public String getAccountRef() {
        return accountRef;
    }
}

