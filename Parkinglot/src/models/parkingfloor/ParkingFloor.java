package models.parkingfloor;

import models.parkingspot.BikeSpot;
import models.parkingspot.CarSpot;
import models.parkingspot.ParkingSpot;
import models.parkingspot.TruckSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private List<ParkingSpot> parkingSpots;
    private int floorNo;

    public ParkingFloor(int floorNo,int numOfSpots) {
        this.floorNo= floorNo;
        this.parkingSpots = new ArrayList<>();
        parkingSpots.add(new TruckSpot(1,floorNo));
        parkingSpots.add(new BikeSpot(2,floorNo));
        parkingSpots.add(new BikeSpot(3,floorNo));
        for(int i=3;i<numOfSpots;i++){
            parkingSpots.add(new CarSpot(i+1,floorNo));
        }
    }

    public ParkingSpot getNextAvailableSpotOfVehicle(String vehicleType){
        for(ParkingSpot spot: this.parkingSpots){
            if(!spot.isOccupied() && spot.getSpotType().equalsIgnoreCase(vehicleType)){
                return spot;
            }
        }
        return null;
    }
    public int getFloorNumber(){
        return  this.floorNo;
    }
    public List<ParkingSpot> getAllparkingSpots(){
        return this.parkingSpots;
    }
    public List<ParkingSpot> getAllAvailableParkingSpotsOfVehicle(String vehicleType){
        List<ParkingSpot> spots = new ArrayList<>();
        for(ParkingSpot spot: this.parkingSpots){
            if(!spot.isOccupied() && spot.getSpotType().equalsIgnoreCase(vehicleType)){
                spots.add(spot);
            }
        }
        return spots;
    }
}
