package io.example.bank;


public interface BankService {
    /**
     * @return an instance of the AccountService providing account management
     */
    AccountService getAccountService();

    /**
     * @return an instance of the TransferService providing account transfers
     */
    TransferService getTransferService();

    /**
     * Support method for setting up the initial state in a persistent store. Targeted
     * for testing only.
     */
    void setupInitialData();
}
