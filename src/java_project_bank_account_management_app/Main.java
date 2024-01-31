package java_project_bank_account_management_app;
import java.io.Console;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int choice = 0;
		while(true) {
			System.out.println("\t\tWelcome to Bank Account Management System");
			System.out.println("\t\t=========================================");
			System.out.println("Press 1 for Creating an Bank Account.");
			System.out.println("Press 2 for Displaying All Bank Accounts.");
			System.out.println("Press 3 for Updating an Bank Account.");
			System.out.println("Press 4 for Deleting an Bank Account.");
			System.out.println("Press 5 for Deposit an Amount to your Bank Account.");
			System.out.println("Press 6 for Withdraw an amount from your Bank Account.");
			System.out.println("Press 7 for Searching an Bank Account.");
			System.out.println("Press 0 for Exit App.");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Enter your choice:");
			
			
			choice = input.nextInt();
			
			switch(choice) {
				case 1:
					CreateAccount ca = new CreateAccount();
					ca.inputAccountInfo();
					goBackToMenu();
					break;
				case 0:
					System.out.println("The Application is Closed.");
					System.exit(0);
					break;
				default:
					System.out.println("Please input valid choice.");
					goBackToMenu();

			}
		}
			
	}
	
	private static void goBackToMenu() {
		try {
			System.out.println("Wait 5 seconds, you will be back to the main menu.");
            Thread.sleep(5000); // Sleep for 5 seconds
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	 

}