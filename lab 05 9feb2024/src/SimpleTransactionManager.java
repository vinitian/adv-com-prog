public class SimpleTransactionManager implements TransactionManager {
    
    private String[] wallets = new String[1000];
    private String[] transactions = new String[10000];    
    private int walletCount;
    private int transactionCount = 0;

    public SimpleTransactionManager(String[] wallets) {
        walletCount = wallets.length;

        // for(int i = 0; i < wallets.length; i++) {
        //     this.wallets[i] = wallets[i];
        // }
        System.arraycopy(wallets,0,this.wallets,0,wallets.length);
    }

    public boolean isValidWallet(String walletId) {
        for (int i = 0; i < walletCount; i++) {
            if (wallets[i].equals(walletId)) {
                return true;
            }
        }
        return false;
    }

    public float getBalance(String walletId) {
        if (!isValidWallet(walletId)) {
            throw new IllegalArgumentException("Invalid wallet ID.");
        }
  
        float balance = 0;
        for (int i = 0; i < transactionCount; i++) {
            String[] parts = transactions[i].split("\\|");
            if (parts[0].equals(walletId)) {
                balance -= Double.parseDouble(parts[2]);
            }
            if (parts[1].equals(walletId)) {
                balance += Double.parseDouble(parts[2]);
            }
        }
  
        return balance;
    }

    public boolean transferFunds(String senderWalletId, String receiverWalletId, double amount) throws InvalidTransactionException {
        if (!isValidWallet(senderWalletId)) {
            throw new IllegalArgumentException("Sender wallet does not exist.");

        }
        
        else if ((senderWalletId != "Wallet0") && (amount > getBalance(senderWalletId))) {
            throw new InvalidTransactionException();
        }
        else {
            if (!isValidWallet(receiverWalletId)){
                this.wallets[walletCount] = receiverWalletId;
                walletCount++;
            }
            this.transactions[transactionCount] = senderWalletId + "|" + receiverWalletId + "|" + amount;
            transactionCount++;
            return true;
        }
    }


}
