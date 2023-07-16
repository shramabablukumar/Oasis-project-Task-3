import java.util.*;

public class User {
    private String userId;
    private int pin;
    private String name;
    private double balance;
    private List<String> transcationHistory;

    public User(String userId, int pin, String name, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.name = name;
        this.balance = balance;
        this.transcationHistory = new ArrayList<>();
    }
    public boolean authenticate(int pin) {
        return this.pin == pin ? true : false;
    }
    public boolean withdraw(double amount) {
        if(amount < balance) {
            balance -= amount;
            String transcation = "Withdrawal: -₹ " + amount + ", New Balance: ₹" + balance + "\n" ;
            transcationHistory.add(transcation);
            return true;
        } else {
            return false;
        }
    }
    public void deposite(double amount) {
        balance += amount;
        String transcation = "Deposit: -₹ " + amount + ", New Balance: ₹" + balance + "\n" ;
        transcationHistory.add(transcation);
    }

    public boolean transfer(double amount, User recipient) {
        if(amount <= balance) {
            balance -= amount;
            recipient.deposite(amount);
            transcationHistory.add("Transfer of ₹ " + amount + " to user " + recipient.getUserId());
            return true;
        } else {
            return false;
        }
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public double getBalance() { return balance; }
    public List<String> getTransactionHistory() { return transcationHistory; }

}