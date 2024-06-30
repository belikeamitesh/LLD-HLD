package CarRentalDesign;

public class Location {
  int pinCode;
  String city;
  String state;
  String country;
  Location(int pinCode,String city,String state,String country){
      this.pinCode=pinCode;
      this.city=city;
      this.country=country;
      this.state=state;
  }
  public int getPinCode(){
      return pinCode;
  }
  public String getCity(){
      return city;
  }
  public String getState(){
      return  state;
  }
  public String getCountry(){
      return  country;
  }
}
