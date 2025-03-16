package exceptions;

public class InvalidParkingSlotException extends Exception{
    public InvalidParkingSlotException(String message){
        super(message);
    }
}
