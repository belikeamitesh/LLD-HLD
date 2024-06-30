package CarRentalDesign;

public class User {
    int userId;
    String userName;
    int drivingLicence;
    public int getUserId(){
        return userId;
    }
    public void setUserId(int id){
        this.userId=id;
    }
    public  String getUserName(){
        return  userName;
    }
    public void setUserName(String userName){
        this.userName=userName;
    }
    public int getDrivingLicence(){
        return drivingLicence;
    }
    public void setDrivingLicence(int drivingLicence){
        this.drivingLicence=drivingLicence;
    }
}
