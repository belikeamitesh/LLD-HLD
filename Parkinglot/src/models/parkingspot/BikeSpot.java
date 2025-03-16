package models.parkingspot;

import models.vehicles.Vehicle;

public class BikeSpot extends ParkingSpot{
    public BikeSpot(int spotNo,int floorNo){
        super(spotNo,floorNo,ParkingSpotType.BIKE);
    }
    @Override
    public boolean canParkVehicle(Vehicle vehicle){
        return "Bike".equalsIgnoreCase(vehicle.getVehicleType().toString());
    }
}
