import java.util.Scanner;

class ATMInter {
    float Balance;
    int PIN = 1234;

    public void checkpin() {
        System.out.println("ENTER THE PIN:");
        Scanner sc = new Scanner(System.in);
        int enteredpin = sc.nextInt();
        if (enteredpin == PIN) {
            menu();
        } else {
            System.out.println("INCORRECT PIN. PLEASE RENTER THE PIN");
        }
    }

    public void menu() {
        System.out.println("ENTER YOUR CHOICE:");
        System.out.println("1. CHECK BALANCE");
        System.out.println("2. WITHDRAW");
        System.out.println("3. DEPOSIT");
        System.out.println("4. EXIT");

        Scanner sc = new Scanner(System.in);
        int opt = sc.nextInt();

        if (opt == 1) {
            checkBalance();
        } else if (opt == 2) {
            withdraw();
        } else if (opt == 3) {
            deposit();
        } else if (opt == 4) {
            System.out.println("THANK YOU! EXITING.");
        } else {
            System.out.println("ENTER A VALID CHOICE");
            menu(); // Retry menu if invalid option is entered
        }
    }

    
    public void checkBalance() {
        System.out.println("ACCOUNT BALANCE: " + Balance);
        menu();
    }

   
    public void withdraw() {
        System.out.println("ENTER THE AMOUNT TO BE WITHDRAWN:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > Balance) {
            System.out.println("INSUFFICIENT ACCOUNT BALANCE");
        } else {
            Balance = Balance - amount;
            System.out.println("AMOUNT WITHDRAWN: " + amount);
        }
        menu();
    }

    
    public void deposit() {
        System.out.println("ENTER THE AMOUNT TO BE DEPOSITED:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        Balance = Balance + amount;
        System.out.println("AMOUNT DEPOSITED SUCCESSFULLY");
        menu();
    }
}

public class ATM {
    public static void main(String[] args) {
        ATMInter obj = new ATMInter(); 
        obj.checkpin();
    }
}
