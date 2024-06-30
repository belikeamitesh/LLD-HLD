package CarRentalDesign;

public class Bill {
    Reservation reservation;
    double totalBillAmount;
    boolean isBillPaid;
    Bill(Reservation reservation){
        this.reservation=reservation;
        this.totalBillAmount = computeBill();
        this.isBillPaid=false;
    }
    public double computeBill(){
        //compute logic
        return 100.0;
    }
}
