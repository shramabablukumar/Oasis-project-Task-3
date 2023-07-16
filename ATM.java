import java.util.*;

public class ATM {
    private static Scanner sc;
    private static Bank bank;

    public ATM() {
        this.sc = new Scanner(System.in);
        this.bank = new Bank();
    }

    public static boolean login() {
        System.out.println("===*** Login ***===");
        System.out.print("Enter UserId: ");
		//String us = sc.nextLine();
        String userId = sc.nextLine();
        System.out.print("Enter Pin: ");
        int pin = sc.nextInt();
        return bank.authenticteUser(userId, pin);
    }

    public void showTranscationHistory() {
        User currUser = bank.getCurrUser();
        if(currUser.getTransactionHistory().size() == 0) {
            System.out.println("You have not done any transaction yet.");
        } else {
            System.out.println("\nTranscation history:");
            for(String transcation : currUser.getTransactionHistory()) System.out.print(transcation);
        }
    }

    public static void withdraw() {
        User currUser = bank.getCurrUser();
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        if(currUser.withdraw(amount)) System.out.println("Withdrawal Successful, New balance: ₹ " + currUser.getBalance());
        else System.out.println("Insufficient Balance");
    }
    public static void deposite() {
        User currUser = bank.getCurrUser();
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        currUser.deposite(amount);
        System.out.println("Deposit Successful, New Balance: ₹ " + currUser.getBalance());
    }
    public static void transfer() {
        User currUser = bank.getCurrUser();
        System.out.print("Enter recipient User id: ");
        String recipientId = sc.nextLine();
        User recipient = bank.getUserById(recipientId);

        if(recipient == null) {
            System.out.println("Recipient Not Found.");
            return;
        }
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        if(currUser.transfer(amount, recipient)) {
            System.out.println("Transfer successful, New balance: ₹ "+ currUser.getBalance());
        } else {
            System.out.println("Insufficient Balance");
        }
    }
}