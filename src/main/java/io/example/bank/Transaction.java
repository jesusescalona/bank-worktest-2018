package io.example.bank;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public final class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String transactionRef;

    private final String transactionType;

    private final Date transactionDate;

    private final List<LedgerEntry> legs;

    public Transaction(String transactionRef, String transactionType,
                       Date transactionDate, List<LedgerEntry> legs) {
        if (transactionRef == null) {
            throw new NullPointerException("transactionRef is null");
        }
        if (transactionType == null) {
            throw new NullPointerException("transactionType is null");
        }
        if (transactionDate == null) {
            throw new NullPointerException("bookingDate is null");
        }
        if (legs == null) {
            throw new NullPointerException("legs is null");
        }
        this.transactionRef = transactionRef;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.legs = legs;
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public List<LedgerEntry> getLegs() {
        return Collections.unmodifiableList(legs);
    }

    public Date getTransactionDate() {
        return new Date(transactionDate.getTime());
    }
}
