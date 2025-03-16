package services.payment;

import java.util.Scanner;

public class PaymentService {
    private Scanner scanner;
    public PaymentService(Scanner scanner){
        this.scanner = scanner;
    }
    public void processPayment(double amount){
        choosePaymentMethod(amount);
    }
    public void choosePaymentMethod(double amount){
        System.out.println("Choose payment method: ");
        System.out.println("1 for Credit card");
        System.out.println("2 for Cash");
        System.out.println("3 for UPI");

        int choice = scanner.nextInt();
        Payment payment;
        switch (choice){
            case 1:
                payment = new Payment(amount, new Creditcard());
                break;
            case 2:
                payment = new Payment(amount, new Cash());
                break;
            case 3:
                payment = new Payment(amount, new UPI());
                break;
            default:
                System.out.println("Invalid choice choosing cash payment as default!");
                payment = new Payment(amount, new Cash());
                break;
        }
        payment.processPayment(amount);
    }
}
