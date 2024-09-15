package CodeAlpha.Task_3;

public class Payment {
    public static boolean processPayment(String customerName, double amount) {
        // In a real system, we would integrate with a payment gateway
        System.out.println("Processing payment for " + customerName + " of amount $" + amount);
        return true;
    }
}
