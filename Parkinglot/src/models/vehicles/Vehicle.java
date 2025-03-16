package models.vehicles;

public abstract  class Vehicle {
    private final String licenceNumber;
    private final String color;
    private final VehicleType vehicleType;
    public Vehicle(String licenceNumber, String color,VehicleType vehicleType){
        this.licenceNumber = licenceNumber;
        this.color = color;
        this.vehicleType = vehicleType;
    }
    public String getLicenceNumber() {
        return licenceNumber;
    }

    public String getColor() {
        return color;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public abstract  double calculateFee(long hoursStayed);
}
