public interface TransactionManager {
    //private String WalletID;
    
    public boolean transferFunds(String senderWalletId, String receiverWalletId, double amount) throws InvalidTransactionException;
    public float getBalance(String walletId);
    public boolean isValidWallet(String walletId);
}
