package controller;

import models.parkinglot.ParkingLot;
import models.parkingspot.ParkingSpot;
import models.ticket.Ticket;
import models.vehicles.Vehicle;
import services.payment.PaymentService;

import java.time.Duration;
import java.time.LocalDateTime;

public class ExitGate {
    private final ParkingLot parkingLot;
    private final PaymentService paymentService;
    private final EntranceGate entranceGate;
    public ExitGate(ParkingLot parkingLot,PaymentService paymentService){
        this.parkingLot = parkingLot;
        this.paymentService = paymentService;
        this.entranceGate = new EntranceGate(parkingLot);
    }
    public void processExit(int spotNo,int hoursStayed){
        ParkingSpot spot = parkingLot.getSpotByNumber(spotNo);
        if(spot==null){
            System.out.println("Invalid or vacant spot");
            return;
        }
        Vehicle vehicle = spot.getVehicle();
        if(vehicle == null) {
            System.out.println("No vehicle found on the given spot :" + spotNo);
            return;
        }
//        long hoursStayed = Duration.between(ticket.getStartTime(), LocalDateTime.now()).toHours();
        double fee = vehicle.calculateFee(hoursStayed);
        paymentService.processPayment(fee);
        parkingLot.vacateSpot(spot,vehicle);

        System.out.println("Vacated succesfully!");
    }
}
