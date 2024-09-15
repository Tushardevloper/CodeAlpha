package CodeAlpha.Task_3;

import java.util.Scanner;

public class BankingApplication {
    long money = 0;
    long customer_money = 0;

    public static void main(String[] args) {
        int pin = 2004;
        long money = 0;
        long customer_money = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the correct PIN number of your account");
        int pin1 = sc.nextInt();

        if (pin1 == pin) {
            System.out.println("Welcome to the Bank. Please choose your option:");
            while (true) {
                System.out.println("Press 1 to Deposit your amount ");
                System.out.println("Press 2 to Withdraw your amount");
                System.out.println("Press 3 to do Balance Enquiry");
                System.out.println("Press 4 to Exit ");
                int p = sc.nextInt();

                switch (p) {
                    case 1:
                        System.out.println("Updation of the Money");
                        System.out.println("Enter the amount you need to deposit");
                        money = sc.nextLong();
                        customer_money = money + customer_money;
                        System.out.println("Your current balance is: " + customer_money);
                        break;

                    case 2:
                        System.out.println("Enter the money you need to withdraw from your current balance");
                        System.out.println("Your current balance is: " + customer_money);
                        System.out.println("Enter the amount you need to withdraw ");
                        long withdraw = sc.nextLong();
                        if (withdraw <= customer_money) {
                            customer_money = customer_money - withdraw;
                            System.out.println("Your current balance after withdrawal is: " + customer_money);
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        break;

                    case 3:
                        System.out.println("Your current balance is: " + customer_money);
                        break;

                    case 4:
                        System.out.println("Have a nice day*");
                        sc.close();
                        break;
                }

                if (p == 4) {
                    break;
                }
            }
        } else {
            System.out.println("You have entered a wrong PIN. Sorry, you are not eligible.");
        }
    }
}
