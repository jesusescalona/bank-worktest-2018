package io.example.bank;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Transfer implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Returns a new builder for creating a transfer request.
     *
     * @return the first build step
     */
    public static StartStep builder() {
        return new Builder();
    }

    public interface StartStep {
        /**
         * @param transactionRef client defined transaction reference
         * @return the next build step
         */
        TypeStep reference(String transactionRef);
    }

    public interface TypeStep {
        /**
         * @param transactionType the transaction type for grouping transactions or other purposes
         * @return the next build step
         */
        AccountStep type(String transactionType);
    }

    public interface AccountStep {
        /**
         * @param accountRef the client defined account reference
         * @return the next build step
         */
        AmountStep account(String accountRef);
    }

    public interface AmountStep {
        /**
         * @param money the transfer amount for the account
         * @return the final build step
         */
        BuildStep amount(Money money);
    }

    public interface BuildStep {
        AmountStep account(String accountRef);

        Transfer build();
    }

    private static final class Builder implements StartStep, TypeStep, AccountStep, AmountStep, BuildStep {
        private final Transfer request = new Transfer();

        private String accountRef;

        @Override
        public TypeStep reference(String transactionRef) {
            request.transactionRef = transactionRef;
            return this;
        }

        @Override
        public AccountStep type(String transactionType) {
            request.transactionType = transactionType;
            return this;
        }

        @Override
        public AmountStep account(String accountRef) {
            this.accountRef = accountRef;
            return this;
        }

        @Override
        public BuildStep amount(Money money) {
            request.legs.add(new LedgerEntry(accountRef, money));
            accountRef = null;
            return this;
        }

        @Override
        public Transfer build() {
            if (request.legs.size() < 2) {
                throw new IllegalStateException("Expected at least 2 legs");
            }
            return request;
        }
    }

    private String transactionRef;

    private String transactionType;

    private final List<LedgerEntry> legs = new ArrayList<>();

    private Transfer() {
    }

    public List<LedgerEntry> getLegs() {
        return Collections.unmodifiableList(legs);
    }

    public String getTransactionRef() {
        return transactionRef;
    }

    public String getTransactionType() {
        return transactionType;
    }
}
