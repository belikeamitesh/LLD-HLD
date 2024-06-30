package CarRentalDesign;

import CarRentalDesign.Product.Vehicle;
import CarRentalDesign.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeId;
    VehicleInventoryManagement inventoryManagement;
    Location startLocation;
    List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType){
        return  inventoryManagement.getVehicles();
    }

    //addvehicle and updatevehicle using inventory management
    public void setVehicles(List<Vehicle> vehicles){
        inventoryManagement = new VehicleInventoryManagement(vehicles);
    }
    public Reservation createReservation(Vehicle vehicle,User user){
        Reservation reservation = new Reservation();
        reservation.createReservation(user,vehicle);
        reservations.add(reservation);
        return reservation;
    }
    public void completeReservation(int reservationId){
        //todo- remove the reservation from list and call complete reservation method
        System.out.println("Reservation completed!");
        reservations.remove(0);
    }
}
