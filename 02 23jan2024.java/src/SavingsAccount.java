public class SavingsAccount extends Account { // SavingsAccount inherited from superclass Account
    
    private double interestRate = 0.0; // set 0.0 as the default value.

    /* 
    public SavingsAccount(String accountID, String accountHolder, double balance) {
        super(accountID, accountHolder, balance);
    }
    */

    public SavingsAccount(String accountID, String accountHolder, double balance, double interestRate) {
        super(accountID, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest(double interestRate) {
        // balance += interestRate * balance // error because balance is private!! 
        // what to do : set balance to protected
        this.deposit(interestRate * this.getBalance());
    }

    public String toString() {
        return "Savings " + super.toString() + ", interestRate: " + interestRate;
    }
    
}
