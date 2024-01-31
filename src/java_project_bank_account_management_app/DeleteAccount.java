package java_project_bank_account_management_app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeleteAccount {
	
	protected void DeleteAccount() {
		
	}
	
	protected void inputAccountNo() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Bank Account No: ");
		String accountNo = input.nextLine();
		deleteAccount(accountNo);
	}
	
	private static void deleteAccount(String accountNumberToDelete) {
        String fileName = "bank_accounts.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("Account Number: ")) {
                    String accountNumber = line.substring("Account Number: ".length()).trim();

                    if (accountNumber.equals(accountNumberToDelete)) {
                        // Skip lines for the account to delete
                        for (int i = 0; i < 9; i++) {
                            br.readLine();
                        }
                    } else {
                        lines.add(line);
                    }
                } else {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the updated content back to the file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Account with number " + accountNumberToDelete + " deleted successfully.");
    }
}
