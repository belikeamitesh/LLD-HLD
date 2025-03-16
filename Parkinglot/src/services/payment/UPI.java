package services.payment;

public class UPI implements PaymentStrategy{
    @Override
    public void processPayment(double amount){
        System.out.println("Processing UPI payment of Rs: "+amount);
    }
}
