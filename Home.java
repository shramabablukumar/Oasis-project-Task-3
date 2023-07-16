import java.util.*;

public class Home {
    private static final int Max_Attempts = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===*** Welcome to STATE BANK OF INDIA ATM ***===\n");
        ATM atm = new ATM();
        int attempts = 0;
        boolean isAuthenticated = false;
        while(attempts < Max_Attempts && !isAuthenticated) {
            if(atm.login()) {
                isAuthenticated = true;
                while(true) {
                    System.out.println("\nChoose an option: ");
                    System.out.println("1. Transaction History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposite");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");

                    System.out.print("Choice: ");
                    int choice = sc.nextInt();

                    switch(choice) {
                        case 1:
                            atm.showTranscationHistory();
                            break;
                        case 2:
                            atm.withdraw();
                            break;
                        case 3:
                            atm.deposite();
                            break;
                        case 4:
                            atm.transfer();
                            break;
                        case 5:
                            System.out.println("Thanks for choosing our ATM. Have a great day!");
                            return;
                        default:
                            System.out.println("Invalid choice, Please try again");
                            break;
                    }
                }
            } else {
                System.out.println("\nInvalid Userid or Pin\nPlease try again.\n");
                attempts++;
                if(attempts < Max_Attempts) System.out.println("Please try again.");
                else System.out.println("Max login attempts reached. Exiting...");
            }
        }
    }

}