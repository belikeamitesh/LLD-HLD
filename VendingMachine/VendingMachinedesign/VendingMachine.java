package VendingMachinedesign;
import VendingMachinedesign.Vendingstates.impl.IdealState;
import VendingMachinedesign.Vendingstates.impl.State;

import java.util.List;
import java.util.ArrayList;

public class VendingMachine {
    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin>coinsList;

    public VendingMachine(){
        vendingMachineState = new IdealState();
        inventory= new Inventory(10);
        coinsList= new ArrayList<>();
    }

    public State getVendingMachineState(){
        return vendingMachineState;
    }
    public void setVendingMachineState(State vendingMachineState){
        this.vendingMachineState = vendingMachineState;
    }
    public Inventory getInventory(){
        return inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory= inventory;
    }
    public List<Coin> getCoinsList(){
        return coinsList;
    }
    public void setCoinsList(List<Coin> coinsList){
        this.coinsList=coinsList;
    }
}
