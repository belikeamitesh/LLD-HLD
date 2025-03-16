package models.parkingspot;

import models.vehicles.Vehicle;

public class TruckSpot extends ParkingSpot{
    public TruckSpot(int spotNo,int floorNo){
        super(spotNo,floorNo,ParkingSpotType.TRUCK);
    }
    @Override
    public boolean canParkVehicle(Vehicle vehicle){
        return "Truck".equalsIgnoreCase(vehicle.getVehicleType().toString());
    }
}
