package VendingMachinedesign.Vendingstates.impl;

import VendingMachinedesign.Coin;
import VendingMachinedesign.Item;
import VendingMachinedesign.VendingMachine;

import java.util.List;

public class HasMoneyState implements State{
    public HasMoneyState(){
        System.out.println("Currently vending machine is in HasMoney state.");
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine)throws Exception{
        return;
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine)throws Exception{
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin)throws Exception{
        System.out.println("Accepted the coin: "+coin.value);
        vendingMachine.getCoinsList().add(coin);
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine,int codeNumber)throws Exception{
        throw new Exception("you need to click on start product selection button to choose anything.");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber)throws Exception{
        throw new Exception("product cannot be dispensed in HasMoney state.");
    }
    @Override
    public int getChange(int returnChangeValue)throws Exception{
        throw new Exception("you cannot get change in HasMoney state.");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception{
       throw new Exception("no refund is returned in HasMoney state.");
    }
}
