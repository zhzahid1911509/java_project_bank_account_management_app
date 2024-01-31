package java_project_bank_account_management_app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayAllAccounts {
	
	protected void DisplayAllAccounts() {
		
	}
	
	protected void displayAllAccountInfo() {
		System.out.println("-------------------------");
		System.out.println("All Accounts Information:");
		System.out.println("-------------------------");
		try {
            BufferedReader reader = new BufferedReader(new FileReader("bank_accounts.txt"));

            String line;
            StringBuilder accountInfo = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    // Empty line indicates the end of an account entry
                    displayAccountInfo(accountInfo.toString());
                    accountInfo.setLength(0);  // Reset StringBuilder for the next account
                } else {
                    accountInfo.append(line).append("\n");
                }
            }

            // Display the last account's information
            displayAccountInfo(accountInfo.toString());

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	private static void displayAccountInfo(String accountInfo) {
        System.out.println(accountInfo);
        System.out.println("--------------------------------------------");
    }
}

