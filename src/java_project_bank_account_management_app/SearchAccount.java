package java_project_bank_account_management_app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchAccount {
	
	protected SearchAccount() {
		
	}
	
	protected void inputAccountNo() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Bank Account No: ");
		String accountNo = input.nextLine();
		searchAccount(accountNo);
	}
	
	private static void searchAccount(String accountNumberToSearch) {
        String fileName = "bank_accounts.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Account Number: ")) {
                    String accountNumber = line.substring("Account Number: ".length()).trim();

                    if (accountNumber.equals(accountNumberToSearch)) {
                        found = true;
                        displayAccountDetails(br);
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Account with number " + accountNumberToSearch + " not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private static void displayAccountDetails(BufferedReader br) throws IOException {
        System.out.println("Account Details:");
        System.out.println("----------------");
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            System.out.println(line);
        }
    }
}
