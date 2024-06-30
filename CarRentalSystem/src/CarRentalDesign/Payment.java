package CarRentalDesign;

public class Payment {
    public void  payBill(Bill bill){
        //do payment processing and update bill status
        System.out.println("Payed the bill");
        bill.isBillPaid=true;
    }
}
