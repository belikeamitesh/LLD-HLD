package CarRentalDesign;

import CarRentalDesign.Product.Bike;
import CarRentalDesign.Product.Car;
import CarRentalDesign.Product.Vehicle;
import CarRentalDesign.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users= addUsers();
        List<Vehicle> vehicles= addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem= new VehicleRentalSystem(stores,users);
        //user comes
        User user= users.get(0);
        //search store based on location
        Location location= new Location(800001,"Patna","Bihar","India");
        Store store= rentalSystem.getStore(location);

        //getall vehicles you are interested in
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

        //reserving the vehicle
        Reservation reservation = store.createReservation(storeVehicles.get(0),users.get(0));
        Bill bill= new Bill(reservation);

        Payment payment=new Payment();
        payment.payBill(bill);

        store.completeReservation(reservation.reservationId);
    }

    public static List<Vehicle> addVehicles(){
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleId(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Bike();
        vehicle2.setVehicleId(2);
        vehicle2.setVehicleType(VehicleType.BIKE);

        Vehicle vehicle3 = new Car();
        vehicle3.setVehicleId(3);
        vehicle3.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicles.add(vehicle3);

        return vehicles;

    }

    public static List<User> addUsers(){
        List<User> users = new ArrayList<>();
        User user= new User();
        user.setUserId(1);
        users.add(user);

        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){
        List<Store> stores= new ArrayList<>();
        Store store1 = new Store();
        store1.storeId=1;
        store1.setVehicles(vehicles);
        stores.add(store1);
        return stores;
    }
}