package CarRentalDesign;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> storeList,List<User> userList){
        this.storeList=storeList;
        this.userList=userList;
    }

    public Store getStore(Location location){
        //based on location filter the store
        return  storeList.get(0);
    }

    //adduser
    public User addUser(String userName,int drivingLicence){
        User newUser =  new User();
        newUser.userId=234;
        newUser.userName=userName;
        newUser.drivingLicence=drivingLicence;
        userList.add(newUser);
        System.out.println("Added new user : "+newUser.getUserName());
        return newUser;
    }
    //remove user
    public void removeUser(User user){
        userList.remove(user);
        System.out.println("Removed user : "+user.getUserName());
    }
    //addstore
    //removestore
}
