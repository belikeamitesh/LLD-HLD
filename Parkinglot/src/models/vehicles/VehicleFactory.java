package models.vehicles;

import exceptions.InvalidVehicleTypeException;

public class VehicleFactory {
    public static Vehicle createVehicle(String licenseNo,String color, String type) {
        if(type.equalsIgnoreCase("Car")){
            return new Car(licenseNo,color,VehicleType.CAR);
        }else if(type.equalsIgnoreCase("Bike")){
            return  new Bike(licenseNo,color,VehicleType.BIKE);
        }else if(type.equalsIgnoreCase("Truck")){
            return new Truck(licenseNo,color,VehicleType.TRUCK);
        }else{
            System.out.println("Vehicle Type is invalid");
            return null;
        }
    }
}
