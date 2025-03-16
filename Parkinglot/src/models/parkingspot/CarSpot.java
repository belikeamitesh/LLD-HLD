package models.parkingspot;

import models.vehicles.Vehicle;

public class CarSpot extends ParkingSpot{
    public CarSpot(int spotNo,int floorNo){
        super(spotNo,floorNo,ParkingSpotType.CAR);
    }
    @Override
    public boolean canParkVehicle(Vehicle vehicle){
        return "Car".equalsIgnoreCase(vehicle.getVehicleType().toString());
    }
}
