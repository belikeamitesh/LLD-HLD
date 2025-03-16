package models.vehicles;

public class Truck extends Vehicle {
    public Truck(String licenseNo, String color,VehicleType vehicleType){
        super(licenseNo,color,vehicleType);
    }
    @Override
    public double calculateFee(long hourStayed){
        return hourStayed>0 ? (hourStayed-1)*12.0 : 0.0;
    }
}
