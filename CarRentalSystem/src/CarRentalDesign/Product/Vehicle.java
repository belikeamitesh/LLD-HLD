package CarRentalDesign.Product;

import java.util.Date;

public class Vehicle {
    VehicleType vehicleType;
    int vehicleId;
    int vehicleNumber;
    String companyName;
    String modelName;
    int kmDriven;
    Date manufacturingDate;
    int average;
    int cc;
    int dailyRentalCost;
    int hourlyRentalCost;
    int noOfSeats;
    Status status;

    public void setVehicleType(VehicleType type){
        this.vehicleType=type;
    }
    public VehicleType getVehicleType(){
        return vehicleType;
    }
    public void setVehicleId(int vehicleId){
        this.vehicleId=vehicleId;
    }
    public int getVehicleId(){
        return vehicleId;
    }
    public void setVehicleNumber(int vehicleNumber){
        this.vehicleNumber=vehicleNumber;
    }
    public int getVehicleNumber(){
        return vehicleNumber;
    }
    public void setCompanyName(String companyName){
        this.companyName=companyName;
    }
    public String getCompanyName(){
        return companyName;
    }
    public void setModelName(String modelName){
        this.modelName=modelName;
    }
    public String getModelName(){
        return modelName;
    }
    public void setKmDriven(int kmDriven){
        this.kmDriven=kmDriven;
    }
    public int getKmDriven(){
        return kmDriven;
    }
    public void setManufacturingDate(Date manufacturingDate){
        this.manufacturingDate=manufacturingDate;
    }
    public Date getManufacturingDate(){
        return manufacturingDate;
    }
    public void setVehicleType(int average){
        this.average=average;
    }
    public int getAverage(){
        return average;
    }
    public void setCc(int cc){
        this.cc = cc;
    }
    public int getCc(){
        return cc;
    }
    public void setHourlyRentalCost(int hourlyRentalCost){
        this.hourlyRentalCost=hourlyRentalCost;
    }
    public int getHourlyRentalCost(){
        return hourlyRentalCost;
    }
    public void setDailyRentalCost(int dailyRentalCost){
        this.dailyRentalCost=dailyRentalCost;
    }
    public int getDailyRentalCost(){
        return dailyRentalCost;
    }
    public void setNoOfSeats(int noOfSeats){
        this.noOfSeats=noOfSeats;
    }
    public int getNoOfSeats(){
        return noOfSeats;
    }
    public void setStatus(Status status){
        this.status=status;
    }
    public Status getStatus(){
        return status;
    }

}
