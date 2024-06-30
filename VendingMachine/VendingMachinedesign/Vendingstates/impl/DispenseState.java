package VendingMachinedesign.Vendingstates.impl;

import VendingMachinedesign.Coin;
import VendingMachinedesign.Item;
import VendingMachinedesign.VendingMachine;

import java.util.List;

public class DispenseState implements State{

    public DispenseState(VendingMachine vendingMachine,int codeNumber) throws Exception {
        System.out.println("Currently vending machine is in Dispense state.");
        dispenseProduct(vendingMachine,codeNumber);
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine)throws Exception{
        throw new Exception("insert coin cannot be clicked in dispense state.");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine)throws Exception{
        throw new Exception("start product selection cannot be clicked in dispense state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin)throws Exception{
        throw new Exception("new coin cannot be inserted in dispense state.");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine,int codeNumber)throws Exception{
        throw new Exception("you need to click on start product selection button to choose anything.");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber)throws Exception{
        System.out.println("Your Product has been dispensed : "+ vendingMachine.getInventory().getItem(codeNumber).getType()+" with price : "+ vendingMachine.getInventory().getItem(codeNumber).getPrice());
        Item item= vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateInventory(codeNumber);
        vendingMachine.setVendingMachineState(new IdealState());
        return item;
    }
    @Override
    public int getChange(int returnChangeValue)throws Exception{
        throw new Exception("you cannot get change in dispense state.");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception{
        throw new Exception("no refund is returned in HasMoney state.");
    }
}
