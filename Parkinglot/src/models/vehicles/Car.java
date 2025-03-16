package models.vehicles;

public class Car extends Vehicle{
    public Car(String licenseNo, String color,VehicleType vehicleType){
        super(licenseNo,color,vehicleType);
    }
    @Override
    public double calculateFee(long hourStayed){
        return hourStayed>0 ? (hourStayed-1)*10.0 : 0.0;
    }
}
