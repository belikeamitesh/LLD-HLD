package VendingMachinedesign.Vendingstates.impl;

import VendingMachinedesign.Coin;
import VendingMachinedesign.Item;
import VendingMachinedesign.VendingMachine;

import java.util.List;

public class SelectionState implements State{
    public SelectionState(){
        System.out.println("Currently vending machine is in Selection state.");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine)throws Exception{
        throw new Exception("insert coin button cannot be clicked in selection state.");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine)throws Exception{
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin)throws Exception{
        throw new Exception("you cannot insert new coin in selection state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine,int codeNumber)throws Exception{
        Item item= vendingMachine.getInventory().getItem(codeNumber);
        int paidByUser=0;
        for(Coin coin:vendingMachine.getCoinsList()){
            paidByUser = paidByUser+ coin.value;
        }

        if (paidByUser < item.getPrice()){
            System.out.println("Insufficient Amount, Product you selected is for price : "+item.getPrice()+" and you paid : "+paidByUser);
            refundMoney(vendingMachine);
            throw new Exception("insufficient amoutn");
        }
        else if(paidByUser >= item.getPrice()){
            if(paidByUser > item.getPrice()){
                getChange(paidByUser- item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine,codeNumber));
        }
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber)throws Exception{
        throw new Exception("product cannot be dispensed in Selection state.");
    }
    @Override
    public int getChange(int returnChangeValue)throws Exception{
        System.out.println("Returned the change in the coin dispense tray : "+returnChangeValue);
        return returnChangeValue;
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception{
        System.out.println("Returned/Refunded the full amount in the coin dispense tray.");
        vendingMachine.setVendingMachineState(new IdealState());
        return vendingMachine.getCoinsList();
    }

}