package models.ticket;

import models.parkingspot.ParkingSpot;
import models.vehicles.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private  String id;
    private  ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Ticket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.id = UUID.randomUUID().toString();
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.startTime = LocalDateTime.now();
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public String getTicketId(){
        return  this.id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
