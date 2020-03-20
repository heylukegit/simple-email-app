package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "johson.com";
    private String email;

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        // Call a method asking for department and return the department
        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        // Call a method to return a random password
        this.password = randomPassword(this.defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate an email address
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" +
                this.department + "." + this.companySuffix;
        System.out.println("Your email is: " + this.email);

    }

    // Ask for the department
    private String setDepartment() {
        System.out.print("Enter the department:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n" +
                "Enter Department Code\n");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if (departmentChoice == 1) {return "sales";}
        else if (departmentChoice == 2) {return "dev";}
        else if (departmentChoice == 3) {return "acct";}
        else {return "";}

    }

    // Generate a random password
    private String randomPassword(int passLength) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[passLength];

        for (int i = 0; i < passLength; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }

        return  String.valueOf(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String newpassword) {
        this.password = newpassword;
    }

    public int getMailboxCapacity() {
        return this.mailboxCapacity;
    }

    public String getAlternateEmail() {
        return this.alternateEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public String showInfo() {
        return "Name: " + this.firstName + " " + this.lastName + "\n" +
                "Company Email: " + this.email + "\n" +
                "Mailbox Capacity: " + mailboxCapacity + "\n";

    }

}
