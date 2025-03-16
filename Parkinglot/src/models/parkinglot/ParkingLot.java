package models.parkinglot;

import models.parkingfloor.ParkingFloor;
import models.parkingspot.ParkingSpot;
import models.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int id;
    private final List<ParkingFloor>floors;
    public ParkingLot(int id,int numOfFloors,int numOfSpotsPerFloor){
        this.id= id;
        floors = new ArrayList<>();
        for(int i=0;i<numOfFloors;i++){
            floors.add(new ParkingFloor(i+1,numOfSpotsPerFloor));
        }
    }
    public int getParkingLotId(){
        return this.id;
    }
    public ParkingSpot findAvailableSpot(String vehicleType){
        for(ParkingFloor floor:floors){
            ParkingSpot spot = floor.getNextAvailableSpotOfVehicle(vehicleType);
            if(spot!=null){
                return spot;
            }
        }
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle){
        ParkingSpot spot = findAvailableSpot(vehicle.getVehicleType().toString());
        if(spot!=null){
            spot.parkVehicle(vehicle);
            System.out.println("Vehicle parked successful in spot: "+spot.getSpotNumber()+" on floor: "+spot.getFloorNo());
            return spot;
        }
        System.out.println("No spot found to park vehicle!");
        return  null;
    }

    public void vacateSpot(ParkingSpot spot,Vehicle vehicle){
        if(spot!=null && spot.isOccupied() && spot.getVehicle().equals(vehicle)){
            spot.vacate();
            System.out.println("Vehicle vacated successfully at spot: "+spot.getSpotNumber()+" on floor: "+spot.getFloorNo());
        }else {
            System.out.println("Invalid operation! Spot is already vacated or Vehicle is invalid!");
        }
    }

    public ParkingSpot getSpotByNumber(int spotNo){
        for(ParkingFloor floor:floors){
            for(ParkingSpot spot: floor.getAllparkingSpots()){
                if(spot.getSpotNumber() == spotNo){
                    return  spot;
                }
            }
        }
        return null;
    }

    public List<ParkingFloor> getAllFloors(){
        return this.floors;
    }
}
