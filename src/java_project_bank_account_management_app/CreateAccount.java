package java_project_bank_account_management_app;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;


public class CreateAccount {
	private String fullName;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String email;
    private String contactNumber;
    private double balance;
    private String creationDateTime;
    private String accountNumber;
    
    protected CreateAccount() {
    	
    }
    
    private CreateAccount(String fullName, String dateOfBirth, String gender, String address, String email, String contactNumber) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.contactNumber = contactNumber;
        this.balance = 0.0;
        this.creationDateTime = getCurrentDateTime();
        this.accountNumber = generateAccountNumber();
    }
    
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
        Date currentDate = new Date();
        return sdf.format(currentDate);
    }
    
    private String generateAccountNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        Date currentDate = new Date();
        String datePart = sdf.format(currentDate);

        Random random = new Random();
        int randomDigits = 100000 + random.nextInt(999999); // Random 6 digits

        return datePart + randomDigits;
    }
    
    private void saveToFile() {
        String fileName = "bank_accounts.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Account Number: " + accountNumber + "\n");
            writer.write("Full Name: " + fullName + "\n");
            writer.write("Date of Birth: " + dateOfBirth + "\n");
            writer.write("Gender: " + gender + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Contact Number: " + contactNumber + "\n");
            writer.write("Balance: " + balance + "\n");
            writer.write("Creation Date-Time: " + creationDateTime + "\n");
            writer.write("\n");

            System.out.println("Account created successfully! Details saved to " + fileName);
            
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error saving account details to file.");
        }
    }
    
    
    protected void inputAccountInfo() {
    	System.out.println("Please provide following info for Creating an Account");
    	Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Enter Gender: ");
        String gender = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        CreateAccount newAccount = new CreateAccount(fullName, dateOfBirth, gender, address, email, contactNumber);
        newAccount.saveToFile();
        
        scanner.close();
    }
}
