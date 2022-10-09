
package walletPackage;

public class Account {
    
    public String accountNumber;
    private String accountHolder;
    private double balance;
    
    public Account(String accNumber, String accHolder, double accBalance) {
        this.accountNumber = accNumber;
        this.accountHolder = accHolder;
        this.balance = accBalance;
    }
    
    public void withdraw(double amount) {
        this.balance = this.balance - amount;
    }
    
    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }
    
    public double getBalance() {
        return this.balance;
    }
}
