// Bank Account Management System 

import java.util.Scanner;

class BankAccount {

    private int accNumber;
    private String holderName;
    private double accBalance;
    private String accType;

    BankAccount(int accNumber, String holderName, double accBalance, String accType) {
        this.accNumber = accNumber;
        this.holderName = holderName;
        this.accBalance = accBalance;
        this.accType = accType;
    }

    public void depositAmount(double amt) {
        if(amt > 0) {
            accBalance += amt;
            System.out.println("Amount Deposited Successfully: " + amt);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdrawAmount(double amt) {
        if(amt <= 0) {
            System.out.println("Invalid withdrawal amount!");
        }
        else if(amt > accBalance) {
            System.out.println("Not enough balance!");
        }
        else {
            accBalance -= amt;
            System.out.println("Amount Withdrawn: " + amt);
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + accBalance);
    }

    public void showAccountDetails() {
        System.out.println("\n----- Account Information -----");
        System.out.println("Account Number : " + accNumber);
        System.out.println("Holder Name    : " + holderName);
        System.out.println("Account Type   : " + accType);
        System.out.println("Balance        : " + accBalance);
    }
}

public class BankManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Type (Savings/Current): ");
        String type = sc.nextLine();

        System.out.print("Enter Opening Balance: ");
        double balance = sc.nextDouble();

        BankAccount userAccount = new BankAccount(number, name, balance, type);

        int option = 0;

        while(option != 5) {

            System.out.println("\nBANK MENU ");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. View Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");

            System.out.print("Select Option: ");
            option = sc.nextInt();

            if(option == 1) {
                System.out.print("Enter deposit amount: ");
                userAccount.depositAmount(sc.nextDouble());
            }
            else if(option == 2) {
                System.out.print("Enter withdrawal amount: ");
                userAccount.withdrawAmount(sc.nextDouble());
            }
            else if(option == 3) {
                userAccount.checkBalance();
            }
            else if(option == 4) {
                userAccount.showAccountDetails();
            }
            else if(option == 5) {
                System.out.println("Thank you! Exiting system...");
            }
            else {
                System.out.println("Invalid menu choice!");
            }
        }

        sc.close();
    }
}
