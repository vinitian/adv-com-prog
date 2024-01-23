// ctrl + shift + p > create new java file > class > name (Account)

public class Account {
    private String accountID;
    private String accountHolder;
    protected double balance; // protected : allows subclasses to read balance
    
    public Account(String accountID, String accountHolder, double balance) {
        this.accountID = accountID;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountHolder(String accountHolder) {
        // Add some rules to protect your account holder
        this.accountHolder = accountHolder;
    }

    public void deposit(double amount) {
        if(amount >= 0.0) {
            this.balance += amount;
        }
        else {
            System.out.println("[Error] Amount is negative (" + amount + ").");
        }
    }

    public void withdraw(double amount) {
        if(amount >= 0.0) {
            if(this.balance >= amount) {
            this.balance -= amount;
            }
            else {
                System.out.println("[Error] Amount is greater than balance.");
            }
        }

        else {
            System.out.println("[Error] Amount is negative (" + amount + ").");
        }
    }

    public String toString() {
        return "Account: " + accountID + ", accountHolder: " + accountHolder + ", balance: " + balance;
    }

}
