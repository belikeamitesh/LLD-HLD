package services.payment;

public class Creditcard implements PaymentStrategy{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing Credit Card payment of Rs: "+amount);
    }
}
