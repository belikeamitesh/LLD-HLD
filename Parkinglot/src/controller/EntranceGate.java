package controller;

import models.parkinglot.ParkingLot;
import models.parkingspot.ParkingSpot;
import models.ticket.Ticket;
import models.vehicles.Vehicle;
import models.vehicles.VehicleFactory;

import java.util.Scanner;

public class EntranceGate {
    private final ParkingLot parkingLot;
    private Ticket ticket;
    public EntranceGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }
    public void processEntrance(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the registration No. of Vehicle: ");
        String regNo = scanner.next();
        System.out.println("Enter the color of Vehicle: ");
        String color = scanner.next();
        System.out.println("Enter type of Vehicle (CAR,BIKE,TRUCK): ");
        String vehicleType = scanner.next();
        Vehicle vehicle = VehicleFactory.createVehicle(regNo,color,vehicleType);
        if (vehicle==null){
            System.out.println("Invalid vehicle type! Only car,bike or trucks are allowed!");
            return;
        }
        ParkingSpot spot = parkingLot.parkVehicle(vehicle);
        if(spot!= null){
            System.out.println("Vehicle parked successfully at spot: "+spot.getSpotNumber()+" on floor: "+spot.getFloorNo());
        }else {
            System.out.println("No available spots for vehicle");
        }
    }
    public Ticket getTicket(String id){
        if(this.ticket.getTicketId().equalsIgnoreCase(id)){
            return this.ticket;
        }
        System.out.println("Ticket not found");
        return  null;
    }
    public ParkingLot getParkingLot(){
        return this.parkingLot;
    }
}
