package models.parkingspot;

import exceptions.InvalidParkingSlotException;
import models.vehicles.Vehicle;

public abstract class ParkingSpot {
    private final int spotNo;
    private boolean isOccupied;
    private final int floorNo;
    private Vehicle vehicle;
    private final ParkingSpotType parkingSpotType;

    public ParkingSpot(int spotNo,int floorNo,ParkingSpotType spotType){
        this.spotNo = spotNo;
        this.parkingSpotType = spotType;
        this.isOccupied = false;
        this.floorNo = floorNo;
    }
    public boolean isOccupied(){
        return this.isOccupied;
    }
    public int getFloorNo(){
        return this.floorNo;
    }
    public abstract boolean canParkVehicle(Vehicle vehicle);

    public void parkVehicle(Vehicle vehicle){
        if(isOccupied){
            System.out.println("Parking slot already occupied!");
            return;
        }
        if(!canParkVehicle(vehicle)){
            System.out.println("Parking slot not apt for this vehicle!");
            return;
        }
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void vacate() {
        if(!isOccupied){
            System.out.println("Parking slot already empty cant vacate!");
            return;
        }
        this.vehicle = null;
        this.isOccupied = false;
    }
    public int getSpotNumber(){
        return this.spotNo;
    }
    public Vehicle getVehicle(){
        return this.vehicle;
    }
    @Override
    public String toString(){
        return "ParkingSpot{" +"spotNo=" +spotNo + ", isOccupied="+isOccupied + ", vehicle=" + ((vehicle!=null)?vehicle.getLicenceNumber():"None") + "}";
    }
    public String getSpotType(){
        return this.parkingSpotType.toString();
    }
}
