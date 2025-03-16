package models.vehicles;

public class Bike extends Vehicle {
    public Bike(String licenseNo, String color,VehicleType vehicleType){
        super(licenseNo,color,vehicleType);
    }
    @Override
    public double calculateFee(long hourStayed){
        return hourStayed>0 ? (hourStayed-1)*5.0 : 0.0;
    }
}
