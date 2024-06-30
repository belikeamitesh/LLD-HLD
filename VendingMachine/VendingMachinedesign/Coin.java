package VendingMachinedesign;
public enum Coin {
    PAISA(1),
    TWENTYRUPEE(20),
    TENRUPEE(10),
    FIFTYRUPEE(50);
    public int value;
    Coin(int value){
        this.value=value;
    }
}
